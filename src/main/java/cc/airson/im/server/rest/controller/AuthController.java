package cc.airson.im.server.rest.controller;

import cc.airson.im.server.rest.handler.AuthHandler;
import cc.airson.im.server.rest.tools.Result;
import cc.airson.im.server.rest.vo.Login;
import com.alibaba.fastjson.JSONObject;
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
//@Api(value = "IM相关接口", tags = "IM")
@RequestMapping(value = "/v1/auth/")
public class AuthController {

    @Autowired
    private AuthHandler handler;

    //private Logger logger = LoggerFactory.getLogger(getClass());
    private static Logger logger = LoggerFactory.getLogger(AuthController.class);

    static {
        logger.trace("login domain log");
    }

    @ApiOperation(value = "IM登录", tags = "IM")
    @RequestMapping(value = "login")
    public JSONObject login(@Valid Login login, BindingResult result) {
        JSONObject json = new JSONObject();
        handler.login(json, login);
        return Result.success(json);
    }

    @ApiOperation(value = "IM登出", tags = "IM")
    @RequestMapping(value = "logout")
    public JSONObject logout(@Valid Login login, BindingResult result) {
        JSONObject json = new JSONObject();
        handler.logout(json, login);
        return Result.success(json);
    }


}
