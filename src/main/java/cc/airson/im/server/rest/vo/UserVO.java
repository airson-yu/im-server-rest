package cc.airson.im.server.rest.vo;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import javax.validation.constraints.Size;


/**
 * 参数校验 Hibernate-Validator
 * https://juejin.im/post/5da051b86fb9a04de513e929
 */
@Data
public class UserVO {

    @Size(min = 5, max = 20, message = "userName-账号参数不符合规范")
    private String userName;

    @Size(min = 5, max = 50, message = "phone-电话号码参数不符合规范")
    private String phone;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
