package cc.airson.im.server.rest.config;

/**
 * TODO
 *
 * @author airson
 */
public class Const {

    public Const() {
        // forbid new instance
    }

    //MQ
    public static final String MQ_INSTANCE       = "kafka";
    public static final String MQ_GROUP_DEMO     = "cg-demo";
    public static final String MQ_GROUP_IM       = "cg-im";
    public static final String MQ_GROUP_USER     = "cg-user";
    public static final String MQ_GROUP_NOTEBOOK = "cg-notebook";
    public static final String MQ_TOPIC_DEMO     = "t-demo";
    public static final String MQ_TOPIC_IM       = "t-im";
    public static final String MQ_TOPIC_USER     = "t-user";
    public static final String MQ_TOPIC_REDIS    = "t-redis";
    public static final String MQ_TOPIC_NOTEBOOK = "t-notebook";

    // WEBSOCKET
    public static final String WS_MSG_TOPIC        = "/topic/greetings";
    public static final String WS_MSG_ENDPOINT     = "/chat";
    public static final String WS_MSG_APP_PREFIX   = "/app";
    public static final String WS_MSG_TOPIC_PREFIX = "/topic";

    // TOKEN
    public static final String SESSION_PRE_KEY     = "s_";
    public static final String SESSION_UID_PRE_KEY = "su_";
    public static final String TOKEN_PRE_KEY       = "t_";

    public static String build_uid_userSession_key(Long uid) {
        return SESSION_PRE_KEY + uid;
    }

    public static String build_sid_uid_key(String sessionId) {
        return SESSION_UID_PRE_KEY + sessionId;
    }

    public static String build_token_uid_key(String token) {
        return TOKEN_PRE_KEY + token;
    }

}
