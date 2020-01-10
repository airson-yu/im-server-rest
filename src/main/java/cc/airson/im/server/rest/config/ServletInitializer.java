package cc.airson.im.server.rest.config;

import cc.airson.im.server.rest.ImServerRestApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 若打包成war包,则需要继承 SpringBootServletInitializer类,覆盖其config方法
 *
 *  SpringBootServletInitializer用于替代传统mvc模式中的web.xml。如果你要使用外部的servlet容器，例如tomcat。
 *  就需要继承该类并重写configure方法。在创建springboot项目时如果你创建的是war，则系统会默认提供一个继承类。
 *  如果创建时选择的是jar，系统不会提供这个继承！后续要改为war需要自己写这个继承！
 *  如果不继承该类会怎么样呢？答：项目无法使用外部容器启动
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ImServerRestApplication.class);
    }

}
