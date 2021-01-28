package cc.airson.im.server.rest.controller;

import cc.airson.im.server.rest.handler.UserHandler;
import cc.airson.im.server.rest.tools.REST;
import cc.airson.im.server.rest.tools.Result;
import cc.airson.im.server.rest.vo.UserVO;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * TODO
 *
 * @author airson
 */
@Validated
@RestController
@Api(value = "用户相关接口", tags = "user")
@RequestMapping(value = "/v1/user/")
public class UserController {

    @Autowired
    private UserHandler userHandler;

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    static {
        logger.trace("user domain log");
    }

    @ApiOperation(value = "新增用户", tags = "user")
    @RequestMapping(value = "add")
    public JSONObject add(@Valid UserVO userVO, BindingResult result) {
        logger.debug("received cmd user add:{}", userVO);
        JSONObject json = new JSONObject();
        userHandler.addUser(json, userVO);
        return REST.success(json, "user_add");
    }

    @ApiOperation(value = "修改用户", tags = "user")
    @RequestMapping(value = "update")
    public JSONObject update(@Valid UserVO userVO, BindingResult result) {
        logger.debug("received cmd user update:{}", userVO);
        JSONObject json = new JSONObject();
        userHandler.updateUser(json, userVO);
        return REST.success(json, "user_update");
    }

    @ApiOperation(value = "加载用户", tags = "user")
    @RequestMapping(value = "load")
    public JSONObject load(@RequestParam Long uid) {
        logger.debug("received user load:{}", uid);
        JSONObject json = new JSONObject();
        userHandler.load(json, uid);
        return REST.success(json, "user_load");
    }

}
