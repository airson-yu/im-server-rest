package cc.airson.im.server.rest.tools;

import org.slf4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionTool {

    /**
     * 打印异常的堆栈详细信息
     *
     * @param logger
     * @param e
     */
    public static void logError(Logger logger, Exception e) {
        e.printStackTrace();
        //logger.trace("Exception : ", e);
        String stackMsg = getMessage(e);
        logger.error(stackMsg);
    }

    private static String getMessage(Exception e) {
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            e.printStackTrace(pw);// 将出错的栈信息输出到printWriter中
            pw.flush();
            sw.flush();
        } finally {
            if (sw != null) {
                try {
                    sw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
        }
        return sw.toString();
    }

}
