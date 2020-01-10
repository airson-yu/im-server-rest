package cc.airson.im.server.rest.tools;

/**
 * <strong> 描&nbsp;&nbsp;&nbsp;&nbsp;述：</strong> 基础库-配置包：路径类 <p>
 * <strong> 作&nbsp;&nbsp;&nbsp;&nbsp;者：</strong> 虞荣华 <p>
 * <strong> 编写时间：</strong> 2016年4月12日12:06:03 <p>
 * <strong> 公&nbsp;&nbsp;&nbsp;&nbsp;司：</strong> 成都蓝海飞鱼科技有限公司 http://lhfeiyu.com <p>
 * <strong> 版&nbsp;&nbsp;&nbsp;&nbsp;本：</strong> 2.0 <p>
 * <strong> 备&nbsp;&nbsp;&nbsp;&nbsp;注：</strong>  <p>
 */
public class BasePage {

    /**
     * 后台页面url统一加前缀
     * 前台页面url不加前缀，命名尽量以业务来命名，避免混淆或不清晰
     */

    public static final String backPrefix = "/back/base/";//后台页面前缀

    // abcdefg hihjklmn opqrst uvwxzy
    /**
     * 后台 基本模块
     */
    public static final String back_admin = backPrefix + "admin/admin";//用户

    public static final String back_announcement  = backPrefix + "article/announcement";    //公告
    public static final String back_annoAddUpdate = backPrefix + "article/annoAddUpdate";    //
    public static final String back_annoDetail    = backPrefix + "article/annoDetail";    //

    public static final String back_article          = backPrefix + "article/article";            //资讯管理
    public static final String back_articleAddUpdate = backPrefix + "article/artilcleAddUpdate";    //
    public static final String back_articleDetail    = backPrefix + "article/artilcleDetail";    //

    /**
     * 公共页面 开始
     */
    public static final String login                = "/front/login";            //前台登陆页面
    public static final String back_login           = "/back/login";            //后台登陆页面
    public static final String back_main            = "/back/main";                //后台主页面
    public static final String back_error           = back_login;                //错误页面
    public static final String back_jumpToBackLogin = "/back/jumpToBackLogin";    //跳转到后台登陆页面

    public static final String error       = "/front/index";    //错误页面
    public static final String jumpToLogin = "/front/toLogin";    //跳转到前台登陆页面
    /** 公共页面 开始 */

}
