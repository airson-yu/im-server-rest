package cc.airson.im.server.rest.advice;

import cc.airson.im.server.rest.config.ResponseCode;
import cc.airson.im.server.rest.tools.Result;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

/**
 * 异常统一处理，
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = ConstraintViolationException.class)
    public Object hibernateValidatorExceptionHandler(ConstraintViolationException e, HttpServletRequest request, HttpServletResponse response) {
        JSONObject json = new JSONObject();
        String message = e.getConstraintViolations().iterator().next().getMessage();
        String[] msgAry = message.split("-");
        String param = msgAry[0];
        String msg = msgAry[1];
        json.put("param", param);
        return Result.failure(json, msg, ResponseCode.PARAM_INVALID.getCode());
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Object exceptionHandler(Exception e, HttpServletRequest request, HttpServletResponse response) {
        JSONObject json = new JSONObject();
        logger.error("server exception:{}", e.getMessage());
        e.printStackTrace();
        return Result.failure(json, ResponseCode.SERVER_EXCEPTION);
    }

}