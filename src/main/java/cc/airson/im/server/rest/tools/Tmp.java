package cc.airson.im.server.rest.tools;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 *
 */
public class Tmp {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "2020-01-07 12:05:16 即时通讯.jpg";
        String result = URLEncoder.encode(str, "UTF-8");
        System.out.println(result);
    }

}
