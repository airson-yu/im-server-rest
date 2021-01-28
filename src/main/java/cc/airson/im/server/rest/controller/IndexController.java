package cc.airson.im.server.rest.controller;

import cc.airson.im.server.rest.tools.REST;
import cc.airson.im.server.rest.tools.Result;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scripting.support.RefreshableScriptTargetSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author airson
 */

@RestController
public class IndexController {

    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "/")
    public JSONObject index() {
        JSONObject json = new JSONObject();
        json.put("tip", "this is im rest server");
        logger.debug("rest server index");
        return REST.success(json, "index");
    }

}
