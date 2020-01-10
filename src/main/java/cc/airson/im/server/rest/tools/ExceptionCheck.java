package cc.airson.im.server.rest.tools;

import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.CannotCreateTransactionException;

public class ExceptionCheck {

    private static Logger logger = LoggerFactory.getLogger(ExceptionCheck.class);

    public static JSONObject checkException(Exception ex, JSONObject json) {

        json.put(BaseTip.key_failure, BaseTip.value_failure);
        json.put(BaseTip.key_status, BaseTip.value_status_failure);

        check_communicationsException(ex, json);
        //check_dataSourceReadOnlyException(ex, json);
        //check_business_exception(ex, json);
        return json;
    }

    public static boolean check_communicationsException(Exception ex, JSONObject json) {

        String msg = json.getString(BaseTip.key_msg);
        String code = json.getString(BaseTip.key_code);

        boolean exception = false;
        boolean isMaster = false;
        //org.springframework.transaction.CannotCreateTransactionException
        //com.alibaba.druid.pool.GetConnectionTimeoutException(login时无此异常)
        //com.mysql.jdbc.exceptions.jdbc4.CommunicationsException
        if (ex instanceof CannotCreateTransactionException) {
            Throwable cause1 = ex.getCause();
            if (null != cause1 && (cause1.getCause() instanceof CommunicationsException || cause1 instanceof CommunicationsException)) {//数据库连接异常,不要绑定到druid异常上，有可能项目不使用此连接池
                isMaster = DynamicDataSourceHolder.isMaster();
                exception = true;
                if (isMaster) {
                    msg = BaseTip.msg_db_remote_disconnected;
                    code = BaseTip.code_db_remote_disconnected;
                } else {
                    msg = BaseTip.msg_db_local_disconnected;
                    code = BaseTip.code_db_local_disconnected;
                }
            }
        }
        json.put(BaseTip.key_msg, msg);
        json.put(BaseTip.key_code, code);

        return exception;
    }

    /*public static boolean check_dataSourceReadOnlyException(Exception ex, JSONObject json) {

        String msg = json.getString(BaseTip.key_msg);
        String code = json.getString(BaseTip.key_code);

        boolean exception = false;

        if (ex instanceof InvalidDataAccessResourceUsageException) {
            Throwable cause1 = ex.getCause();
            String msgs = null;
            if (cause1 instanceof SQLException) { // XXX FIXME 使用8.0连接，是否能正确捕获? MySQLSyntaxErrorException 2019年8月28日17:57:27
                msgs = cause1.getMessage();
            }
            if (null != msgs && msgs.contains("denied to user")) {
                exception = true;
                msg = BaseTip.msg_db_read_only;
                code = BaseTip.code_db_read_only;
                logger.warn("当前数据库处于只读模式 : {}" + msg);
            } else {
                logger.error("数据库语法错误 : {}" + ex.getMessage());
            }
        }

        if (ex instanceof DataSourceReadOnlyException) {//只读模式不可写
            exception = true;
            msg = BaseTip.msg_db_read_only;
            code = BaseTip.code_db_read_only;
            logger.warn("当前数据库处于只读模式 : {}" + msg);
        }
        json.put(BaseTip.key_msg, msg);
        json.put(BaseTip.key_code, code);

        return exception;
    }*/

    /**
     * 当异常为CmsException时，修改报错信息
     *
     * @param ex
     * @param json
     */
    /*public static void check_business_exception(Exception ex, JSONObject json) {
        String msg = json.getString(BaseTip.key_msg);
        String code = json.getString(BaseTip.key_code);
        if (ex instanceof CmsException) {
            json.put(BaseTip.key_msg, ex.getMessage());
        }
    }*/
}
