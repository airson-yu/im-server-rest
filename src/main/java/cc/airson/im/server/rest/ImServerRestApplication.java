package cc.airson.im.server.rest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableEurekaClient
@MapperScan("cc.airson.im.server.rest.dao.mapper")
@SpringBootApplication
public class ImServerRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImServerRestApplication.class, args);
    }

}
