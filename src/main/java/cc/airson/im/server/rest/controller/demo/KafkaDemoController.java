package cc.airson.im.server.rest.controller.demo;

import cc.airson.im.server.rest.config.Const;
import cc.airson.im.server.rest.tools.Result;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * TODO
 * https://juejin.im/entry/5a9e65296fb9a028dc408af5
 *
 * @author airson
 */
@Controller
public class KafkaDemoController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @KafkaListener(topics = {Const.MQ_TOPIC_DEMO}, groupId = Const.MQ_GROUP_DEMO)
    public void processMessage(String content) {
        // ...
        logger.debug("demoTopic content:{}", content);
    }

    @ResponseBody
    @RequestMapping(value = "/kafka_demo")
    public JSONObject kafka_demo(HttpServletRequest request, HttpSession session, String message) {
        logger.debug("kafka_demo message:{}", message);

        JSONObject json = new JSONObject();
        json.put("message", message);

        kafkaTemplate.send(Const.MQ_TOPIC_DEMO, message);

        return Result.success(json);

    }

}
