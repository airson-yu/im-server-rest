package cc.airson.im.server.rest.vo;

import lombok.Data;

import javax.validation.constraints.Size;


/**
 * 参数校验 Hibernate-Validator
 * https://juejin.im/post/5da051b86fb9a04de513e929
 */
@Data
public class Login {

    @Size(min = 5, max = 20, message = "account-账号参数不符合规范")
    private String account;

    @Size(min = 5, max = 50, message = "password-密码参数不符合规范")
    private String password;

}
