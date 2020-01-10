package cc.airson.im.server.rest.config;

/**
 * TODO
 *
 * @author airson
 */
public enum ResponseCode {

    SERVER_EXCEPTION("5000", "系统繁忙，请稍后再试"),
    PARAM_INVALID("5001", "参数错误"),//应该由具体参数错误覆盖
    LOGIN_USER_NULL("5100", "账号或密码不正确");



    private String code;
    private String message;

    ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
