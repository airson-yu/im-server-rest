package cc.airson.im.server.rest.handler;

import cc.airson.im.server.rest.config.Const;
import cc.airson.im.server.rest.dao.po.User;
import cc.airson.im.server.rest.service.UserService;
import cc.airson.im.server.rest.tools.MQMsgBuilder;
import cc.airson.im.server.rest.tools.Result;
import cc.airson.im.server.rest.vo.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * TODO
 *
 * @author airson
 */
@Component
public class UserHandler {

    @Autowired
    private UserService   userService;
    @Autowired
    private KafkaTemplate kafkaTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    //private Logger logger = LoggerFactory.getLogger(getClass());
    private static Logger logger = LoggerFactory.getLogger(UserHandler.class);

    public JSONObject addUser(JSONObject json, UserVO userVO) {
        User user = new User();
        user.setUserName(userVO.getUserName());
        user.setPhone(userVO.getPhone());
        user.setCreateTime(new Date());
        userService.insert(user);

        String userKey = "u_" + user.getId();
        String userData = JSON.toJSONString(user);

        json.put("user", userData);
        logger.debug("add user:{}", userData);

        redisTemplate.opsForValue().set(userKey, userData);
        redisTemplate.opsForList().rightPush("ulist", userData);
        kafkaTemplate.send(Const.MQ_TOPIC_USER, MQMsgBuilder.user_add(user));

        Result.success(json);
        return json;
    }

    public JSONObject updateUser(JSONObject json, UserVO userVO) {
        User user = new User();
        user.setUserName(userVO.getUserName());
        user.setPhone(userVO.getPhone());
        user.setUpdateTime(new Date());
        userService.update(user);
        // TODO send kafka message to ws project, ws project save the message

        String userKey = "u_" + user.getId();
        String userData = JSON.toJSONString(user);

        json.put("user", userData);
        logger.debug("update user:{}", userData);

        redisTemplate.opsForValue().set(userKey, userData);
        redisTemplate.opsForList().rightPush("ulist", userData);
        kafkaTemplate.send(Const.MQ_TOPIC_USER, MQMsgBuilder.user_update(user));

        Result.success(json);
        return json;
    }

    public JSONObject deleteUser(JSONObject json, Long id) {

        return json;
    }

    public JSONObject load(JSONObject json, Long id) {
        String userKey = "u_" + id;
        Object userObj = redisTemplate.opsForValue().get(userKey);
        if (null != userObj) {
            JSONObject userJson = (JSONObject) userObj;
            json.put("data", userJson);
            logger.debug("load user from redis:{}", id);
        }
        User user = userService.load(id);
        if (null != user) {
            json.put("data", user);
            logger.debug("load user from db:{}", id);
        } else {
            logger.debug("load user null:{}", id);
        }

        return json;
    }

}
