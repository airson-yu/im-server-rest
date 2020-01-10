package cc.airson.im.server.rest.controller.demo;

import cc.airson.im.server.rest.config.Const;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * TODO
 * https://juejin.im/post/5cf46fe36fb9a07ec373d730
 *
 * @author airson
 */
@Controller
public class RedisDemoController {

    @Autowired
    private RedisTemplate       redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private KafkaTemplate       kafkaTemplate;

    private Logger logger = LoggerFactory.getLogger(getClass());

    /*private final RedisTemplate       redisTemplate;
    private final StringRedisTemplate stringRedisTemplate;
    private final KafkaTemplate       kafkaTemplate;
    public RedisDemoController(RedisTemplate redisTemplate, StringRedisTemplate stringRedisTemplate, KafkaTemplate kafkaTemplate) {
        this.redisTemplate = redisTemplate;
        this.stringRedisTemplate = stringRedisTemplate;
        this.kafkaTemplate = kafkaTemplate;
    }*/

    @KafkaListener(topics = {Const.MQ_TOPIC_REDIS}, groupId = Const.MQ_GROUP_DEMO)
    public void processMessage(String content) {
        // ...
        ValueOperations ops = redisTemplate.opsForValue();
        String message = (String) ops.get(content);
        logger.debug("demo redisTopic message:{}", message);
    }

    @ResponseBody
    @RequestMapping(value = "/redis_demo")
    public JSONObject redis_demo(HttpServletRequest request, HttpSession session, String message) {
        logger.debug("redis_demo message:{}", message);

        JSONObject json = new JSONObject();
        json.put("message", message);

        ValueOperations ops = redisTemplate.opsForValue();

        ops.set(message, "redis-message:" + message);
        kafkaTemplate.send(Const.MQ_TOPIC_REDIS, message);

        return json;

    }

}
