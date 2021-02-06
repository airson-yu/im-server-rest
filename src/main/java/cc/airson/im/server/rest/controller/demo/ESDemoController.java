package cc.airson.im.server.rest.controller.demo;

import cc.airson.im.server.rest.config.Const;
import cc.airson.im.server.rest.controller.AuthController;
import cc.airson.im.server.rest.tools.Result;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * TODO
 * https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-elasticsearch
 *
 * @author airson
 */
@Controller
public class ESDemoController {

    @Autowired
    private ElasticsearchRestTemplate esTemplate;
    @Autowired
    private RestHighLevelClient       esClient;

    //private Logger logger = LoggerFactory.getLogger(getClass());
    private static Logger logger = LoggerFactory.getLogger(ESDemoController.class);

    @ResponseBody
    @RequestMapping(value = "/es_demo")
    public JSONObject es_demo(HttpServletRequest request, HttpSession session, String message) {
        logger.debug("es_demo message:{}", message);

        JSONObject json = new JSONObject();
        json.put("message", message);

        //esTemplate.indexOps().create("yrh_test");
        CreateIndexRequest esRequest = new CreateIndexRequest("idx_yrh");
        CreateIndexResponse createIndexResponse = null;
        try {
            createIndexResponse = esClient.indices().create(esRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.debug("createIndex:{}", JSON.toJSONString(createIndexResponse));

        return Result.success(json);

    }

}
