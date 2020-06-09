package kr.co.fastcampus.cli.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import kr.co.fastcampus.cli.controller.MemberController;
import kr.co.fastcampus.cli.dao.MemberDao;
import kr.co.fastcampus.cli.service.MemberService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.sql.DataSource;

//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//
@Configuration
//@Profile("dev | default")
//@Profile({"dev", "default"})
//@ComponentScan(basePackages = "kr.co.fastcampus.cli")
@PropertySource("classpath:application.properties") //여기에 한번에 설
@EnableAspectJAutoProxy
@EnableTransactionManagement
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
//    @Bean
//    public B b(){
//        return new B();
//    }
//    @Bean(initMethod = "init",destroyMethod = "destroy")
//    public A a(B b){
//        return new A(b);
//    }

//    @Bean
//    public Connection connection(ConnectionFactory connectionFactory){
//        return connectionFactory.getConnection();
//    }


//    @Bean(initMethod = "init", destroyMethod = "destroy")
//    public ConnectionFactory connectionFactory(
//            @Value("${jdbc.driver-name}") String driverClass,
//            @Value("${jdbc.url}") String url,
//            @Value("${jdbc.username}") String username,
//            @Value("${jdbc.password}") String password
//    ){
//        return new ConnectionFactory(driverClass,url,username,password);
//    }

    @Bean
    public DataSource dataSource(
            @Value("${jdbc.driver-name}") String driverClass,
            @Value("${jdbc.url}") String url,
            @Value("${jdbc.username}") String username,
            @Value("${jdbc.password}") String password
    ){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driverClass);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password );

        return new HikariDataSource(config);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public MemberDao dao(JdbcTemplate jdbcTemplate){
        return new MemberDao(jdbcTemplate);
    }

    @Bean
    public MemberService memberService(MemberDao dao){
        return new MemberService(dao);
    }

    @Bean
    public MemberController memberController(MemberService service){
        return new MemberController(service);
    }
    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean(){
        return new LocalValidatorFactoryBean();
    }
 }
