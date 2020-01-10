package cc.airson.im.server.rest.tools;

/**
 * <strong> 描&nbsp;&nbsp;&nbsp;&nbsp;述：</strong> 基础库-配置包：提示信息配置 <p>
 * <strong> 作&nbsp;&nbsp;&nbsp;&nbsp;者：</strong> 虞荣华 <p>
 * <strong> 编写时间：</strong> 2016年4月12日12:06:03 <p>
 * <strong> 公&nbsp;&nbsp;&nbsp;&nbsp;司：</strong> 成都蓝海飞鱼科技有限公司 http://lhfeiyu.com <p>
 * <strong> 版&nbsp;&nbsp;&nbsp;&nbsp;本：</strong> 2.0 <p>
 * <strong> 备&nbsp;&nbsp;&nbsp;&nbsp;注：</strong>  <p>
 */
public class BaseTip {

    public static final String commonLoginLogDescription = "正常登陆";//登陆日志描述：正常登陆

    /**
     * ================================== 提示消息 开始 ==================================
     */

    //典型示例：return Result.failure(json, BaseTip.msg_username_null, BaseTip.code_username_null);

    //msg

    public static final String msg_server_error             = "服务器出现异常，请联系管理员";
    public static final String msg_session_invalid          = "您长时间未操作，为了账户安全请重新登陆";
    public static final String msg_session_invalid_redirect = "会话过期，重定向到登陆页面";

    public static final String msg_admin_null            = "用户不存在";
    public static final String msg_admin_session_invalid = "会话过期，请重新登陆";
    public static final String msg_apply_user_null       = "申请人不能为空";

    public static final String msg_auth_lack = "权限不足";

    public static final String msg_old_password_wrong  = "旧密码不正确";
    public static final String msg_operation_success   = "操作成功";
    public static final String msg_operation_failure   = "操作失败";
    public static final String msg_operation_undefined = "无法识别的操作类型";

    public static final String msg_password_length_lack  = "密码长度不能低于为" + BaseConst.password_min_length + "位";
    public static final String msg_password_special_char = "密码不能包含特殊字符";

    public static final String msg_province_city_null = "省市不能为空";
    public static final String msg_addressDetail_null = "详细地址不能为空";

    public static final String msg_param_lack = "参数不足，无法进行操作";
    public static final String msg_param_null = "参数为空，无法进行操作";

    public static final String msg_db_remote_disconnected = "远程数据库连接失败，无法进行操作";
    public static final String msg_db_local_disconnected  = "本地数据库连接失败，无法进行操作";
    public static final String msg_db_read_only           = "当前为本地只读模式，无法添加、修改、删除数据";

    public static final String code_admin_null            = "admin_null";
    public static final String code_admin_session_invalid = "admin_session_invalid";

    public static final String code_old_password_wrong  = "old_password_wrong";
    public static final String code_operation_success   = "operation_success";
    public static final String code_operation_failure   = "operation_failure";
    public static final String code_operation_undefined = "operation_undefined";

    public static final String code_password_length_lack  = "password_length_lack";
    public static final String code_password_special_char = "password_special_char";
    public static final String code_phone_repeat          = "phone_repeat";

    public static final String code_province_city_null = "province_city_null";
    public static final String code_addressDetail_null = "addressDetail_null";

    public static final String code_param_lack = "param_lack";
    public static final String code_param_null = "param_null";

    public static final String code_server_error             = "server_error";
    public static final String code_session_invalid          = "session_invalid";
    public static final String code_session_invalid_redirect = "session_invalid_redirect";

    public static final String code_login_doLogin              = "doLogin";
    public static final String code_login_wxRedirect           = "wxRedirect";
    public static final String code_login_already              = "already";
    public static final String code_login_jumpToFocus          = "jumpToFocus";
    public static final String code_login_bindPhoneSetPassword = "bindPhoneSetPassword";
    public static final String code_login_notForce             = "notForce";

    public static final String code_db_remote_disconnected = "db_remote_disconnected";
    public static final String code_db_local_disconnected  = "db_local_disconnected";
    public static final String code_db_read_only           = "db_read_only";

    //key

    public static final String key_code = "code";

    public static final String key_failure = "failure";

    public static final String key_grid_rows  = "rows";
    public static final String key_grid_total = "total";

    public static final String key_jumpUrl = "jumpUrl";

    public static final String key_msg = "msg";

    public static final String key_session_flag = "session_flag";
    public static final String key_status       = "status";
    public static final String key_success      = "success";

    public static final String key_toLogin = "toLogin";

    public static final String key_loginStatus = "loginStatus";

    //value

    public static final String value_failure = "failure";

    public static final String value_session_user        = "user";
    public static final String value_status_failure      = "failure";
    public static final String value_status_server_error = "status_server_error";
    public static final String value_status_success      = "success";
    public static final String value_success             = "success";

    public static final String value_toLogin = "1";

    public static final String value_sys_createdBy = "-SYS-";
    public static final String value_sys_updatedBy = "-SYS-";
    public static final String value_sys_deletedBy = "-SYS-";

    /**================================== 提示消息 结束  ==================================*/
}
