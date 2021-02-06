package cc.airson.im.server.rest.model;


/**
 * 第三方平台状态码
 * @author airsonyu
 */
public enum ReturnCode {

    /**
     *
     * 一般请求流程：
     * 客户端发起请求 -> 前置过滤器鉴权 -> 检查参数合法性 -> 业务前置检查 -> 执行业务 -> 执行结果 -> 返回结果 -> 后置过滤器
     *
     * 状态码列表
     * 0: 成功
     * 500 - 999: 通用异常
     * 1000-1999: 前置过滤器鉴权-异常，如签名不合法等
     * 2000-2999: 检查参数合法性-异常，如请求参数不符合规范
     * 3000-3999: 业务前置检查-异常，如请求的数据不存在，或请求人权限不足等
     * 4000-4999: 执行业务-异常，如数据库无法连接等
     * 5000-5999: 执行结果-异常，如执行的结果不符合预期
     * 6000-6999: 返回结果-异常，如在组装返回数据时出现异常
     * 7000-7999: 后置过滤器-异常，如返回的数据不符合通用规范
     *
     * 状态码数值越大，说明在业务流程中出错的位置越靠后
     * 状态码数值越小，说明在业务流程中出错的位置越靠前
     */

    SUCCESS(0, "正确返回"),

    /**
     * 500-999: 通用异常
     */
    SERVER_ERROR(500, "服务器异常"),

    /**
     * 1000-1999: 前置过滤器鉴权-异常，如签名不合法等
     */
    //SERVER
    SERVER_REJECT(1000, "服务器拒绝请求"),
    SERVER_REJECT_STOP(1001, "服务器拒绝请求，服务器暂停业务"),
    SERVER_REJECT_EXCEED(1002, "服务器拒绝请求，请求频率超过限制"),
    //AUTH
    AUTH_PARAM_LACK(1010, "鉴权失败，缺少必要参数"),
    AUTH_PARAM_INVALID(1011, "鉴权失败，参数不符合规范"),
    AUTH_FAILURE(1012, "鉴权失败"),
    AUTH_TOKEN_INVALID(1013, "Token无效或已过期"),
    AUTH_LACK(1014, "权限不足"),
    AUTH_ERROR(1015, "鉴权失败，出现异常"),

    /**
     * 2000-2999: 检查参数合法性-异常，如请求参数不符合规范
     */
    PARAM_INVALID(2000, "参数不符合规范"),
    PARAM_DATETIME_INVALID(2001, "参数不符合规范，时间解析失败");


    private final int value;

    private final String reasonPhrase;

    ReturnCode(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    /**
     * Return the integer value of this status code.
     */
    public int value() {
        return this.value;
    }

    /**
     * Return the reason phrase of this status code.
     */
    public String getReasonPhrase() {
        return reasonPhrase;
    }

    /**
     * Return a string representation of this status code.
     */
    @Override
    public String toString() {
        return Integer.toString(value);
    }

    /**
     * Return the enum constant of this type with the specified numeric value.
     *
     * @param statusCode the numeric value of the enum to be returned
     * @return the enum constant with the specified numeric value
     * @throws IllegalArgumentException if this enum has no constant for the specified numeric value
     */
    public static ReturnCode valueOf(int statusCode) {
        for (ReturnCode status : values()) {
            if (status.value == statusCode) {
                return status;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + statusCode + "]");
    }

}

