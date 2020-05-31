package kr.co.fastcampus.cli;

import kr.co.fastcampus.cli.service.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.sql.Connection;

//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//
@Configuration
//@Profile("dev | default")
@Profile({"dev", "default"})
//@ComponentScan(basePackages = "kr.co.fastcampus.cli")
//@PropertySource("classpath:application-${spring.profiles.active}.properties") 여기에 한번에 설
public class AppConfig {
//    @Bean
//    //@Primary
//    //@Qualifier("b1")
//    public B b1(){
//        return new B();
//    }
//
//    @Bean
//    //@Qualifier("b1")
//    public B b2(){
//        return new B();
//    }
    @Bean
    public B b(){
        return new B();
    }
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public A a(B b){
        return new A(b);
    }

    @Bean
    public Connection connection(ConnectionFactory connectionFactory){
        return connectionFactory.getConnection();
    }

    @Bean
    public Dao dao(Connection connection){
        return new Dao(connection);
    }

    /*@Bean(initMethod = "init", destroyMethod = "destroy")
    public ConnectionFactory connectionFactory(
            @Value("${jdbc.driver-name}") String driverClass,
            @Value("${jdbc.url}") String url,
            @Value("${jdbc.username}") String username,
            @Value("${jdbc.password}") String password
    ){
        return new ConnectionFactory(driverClass,url,username,password);
    }*/

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean(){
        return new LocalValidatorFactoryBean();
    }
    @Bean
    public MyService myService(){
        return new MyService();
    }
}
