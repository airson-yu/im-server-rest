package cc.airson.im.server.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /*public void addResourceHandlers(ResourceHandlerRegistry registry) {
        VersionResourceResolver versionResourceResolver = new VersionResourceResolver()
                .addVersionStrategy(new ContentVersionStrategy(), "/**");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/")
                .setCachePeriod(0).resourceChain(false).addResolver(versionResourceResolver);
        addResourceHandlers(registry);
    }*/

    /*@Override
    public void addCorsMappings(CorsRegistry registry) {
        //添加映射路径
        registry.addMapping("/**")
                //放行哪些原始域
                .allowedOrigins("*")
                //放行哪些原始域(请求方式)
                .allowedMethods("*")
                //是否发送Cookie信息
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
        //暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
        //.exposedHeaders("Header1", "Header2");
    }*/

}
