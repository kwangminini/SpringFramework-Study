package kr.co.fastcampus.cli;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//
@Configuration
@Profile("default")
@PropertySource("classpath:application.properties")
//@ComponentScan(basePackages = "kr.co.fastcampus.cli")
public class AppDefaultConfig {
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
/*    @Bean
    public B b(){
        return new B();
    }
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public A a(B b){
        return new A(b);
    }*/

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public ConnectionFactory connectionFactory(
            @Value("${jdbc.driver-name}") String driverClass,
            @Value("${jdbc.url}") String url,
            @Value("${jdbc.username}") String username,
            @Value("${jdbc.password}") String password
            ){
        return new ConnectionFactory(driverClass,url,username,password);
    }

   /* @Bean
    public Connection connection(ConnectionFactory connectionFactory){
        return connectionFactory.getConnection();
    }

    @Bean
    public Dao dao(Connection connection){
        return new Dao(connection);
    }*/
}
