package cc.airson.im.server.rest.tools;


import cc.airson.im.server.rest.dao.po.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.Calendar;

public class MQMsgBuilder {

    private static final int code_user_add    = 11;
    private static final int code_user_update = 12;
    private static final int code_user_delete = 13;

    public static String user_add(User user) {
        JSONObject msg = new JSONObject();
        msg.put("code", code_user_add);
        msg.put("data", user);
        msg.put("ts", Calendar.getInstance().getTimeInMillis());
        return JSON.toJSONString(msg);
    }

    public static String user_update(User user) {
        JSONObject msg = new JSONObject();
        msg.put("code", code_user_update);
        msg.put("data", user);
        msg.put("ts", Calendar.getInstance().getTimeInMillis());
        return JSON.toJSONString(msg);
    }

}
