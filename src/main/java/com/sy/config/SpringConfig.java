package com.sy.config;


import com.sy.interceptor.LoginInterceptor;
import com.sy.interceptor.SysConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.sy"})
//生成mapper接口的实现类对像(动态代理产生的对像)
@MapperScan(basePackages = "com.sy.mapper")
//引入其他配置
@ImportAutoConfiguration(classes = SysConfig.class)
public class SpringConfig {

    @Bean(name = "loginInterceptor")
    public LoginInterceptor createSysInterceptor(){

        return new LoginInterceptor();
    }

}
