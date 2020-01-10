package cc.airson.im.server.rest.handler;

import cc.airson.im.server.rest.advice.DomainException;
import cc.airson.im.server.rest.config.Const;
import cc.airson.im.server.rest.config.ResponseCode;
import cc.airson.im.server.rest.dao.po.User;
import cc.airson.im.server.rest.service.UserService;
import cc.airson.im.server.rest.tools.Result;
import cc.airson.im.server.rest.tools.SecurityUtil;
import cc.airson.im.server.rest.vo.Login;
import cc.airson.im.server.rest.vo.Message;
import cc.airson.im.server.rest.vo.UserSession;
import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

/**
 * TODO
 *
 * @author airson
 */
@Component
public class AuthHandler {

    @Autowired
    private UserService   userService;
    @Autowired
    private KafkaTemplate kafkaTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public JSONObject send_message(Message message) {
        JSONObject json = new JSONObject();
        if (null == message || StringUtils.isEmpty(message.getContent())) {
            logger.info("message empty");
            json.put("success", false);
            json.put("msg", "message empty");
            Result.failure(json, "消息不能为空", "msg_empty");
            return json;
        }
        logger.debug("send message:{}", message);

        json.put("message", message);

        kafkaTemplate.send(Const.MQ_TOPIC_IM, JSON.toJSONString(message));

        Result.success(json);
        return json;
    }

    public JSONObject login(JSONObject json, Login login) {
        User user = userService.selectForLogin(login.getAccount(), login.getPassword());
        if (null == user) {
            return Result.failure(json, ResponseCode.LOGIN_USER_NULL);
        } else {
            Long uid = user.getId();
            //生成token
            String token = buildToken(uid);
            // TODO redis 缓存登录信息
            String uid_userSession_key = Const.build_uid_userSession_key(uid);
            String token_uid_key = Const.build_token_uid_key(token);
            UserSession userSession = new UserSession(uid, token);
            redisTemplate.opsForValue().set(uid_userSession_key, userSession);
            redisTemplate.opsForValue().set(token_uid_key, uid_userSession_key);
            json.put("uid", uid);
            json.put("token", token);
            logger.debug("user login uid:{},token:{}", uid_userSession_key, token_uid_key);
            return Result.success(json);
        }
    }

    public JSONObject logout(JSONObject json, Login login) {

        return Result.success(json);
    }

    private String buildToken(Long uid) {
        return buildToken(uid, 30, Calendar.SECOND);
    }

    private String buildToken(Long uid, int validTimeGap, int calendarLevel) {
        if (null == uid) {
            throw new DomainException();
        }
        Calendar cal = Calendar.getInstance();
        cal.add(calendarLevel, validTimeGap);
        String seed = "token_" + cal.getTimeInMillis() + "_" + uid;
        String token;
        try {
            token = SecurityUtil.md5(seed);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            token = SecurityUtil.encryptPassword(seed);
            logger.warn("buildToken error: {}", seed);
        }
        logger.info("buildToken seed: {},token: {},time:{}", seed, token, cal.getTime().toString());
        return token;
    }

}
