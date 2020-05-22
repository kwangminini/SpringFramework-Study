package kr.co.fastcampus.cli;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.sql.Connection;

//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//
@Configuration
@Profile("dev")
//@ComponentScan(basePackages = "kr.co.fastcampus.cli")
public class AppDevConfig {
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

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public ConnectionFactory connectionFactory(){
        return new ConnectionFactory("org.h2.Driver","jdbc:h2:mem:test","sa","");
    }

    @Bean
    public Connection connection(ConnectionFactory connectionFactory){
        return connectionFactory.getConnection();
    }

    @Bean
    public Dao dao(Connection connection){
        return new Dao(connection);
    }
}
