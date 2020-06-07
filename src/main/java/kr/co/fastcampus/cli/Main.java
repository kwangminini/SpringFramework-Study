package kr.co.fastcampus.cli;

import kr.co.fastcampus.cli.aop.TransactionBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
//@Configuration
//@ComponentScan(basePackageClasses = Main.class, excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = B.class))
//@ComponentScan(basePackageClasses = Main.class, excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,pattern = "kr.co.fastcampus.cli.B"))
public class Main {

    public static void main(String[] args) throws SQLException {
        log.info("hello");
        //ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
        //ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dao.xml"); //class넣는게 실수를 줄여준다.
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class,AppDefaultConfig.class,AppDevConfig.class); //Configuration 설정
        context.register(TransactionBean.class);
        context.refresh();
        createTable(context.getBean(Connection.class));
        Dao dao = context.getBean(Dao.class);
        dao.insert();
        dao.print();



//        MyService service = context.getBean(MyService.class);
//        service.check();

        //Dao2 dao2 = context.getBean(Dao2.class);
        //context.scan("kr.co.fastcampus.cli");
        //B b = context.getBean(B.class);
        /*Dao b = context.getBean(Da o.class);
        b.run();
        log.info(""+b);*/
        context.close();
        //dao2.run();
//        ConnectionFactory factory = context.getBean(ConnectionFactory.class);
//        Connection connection = factory.getConnection();
//        log.info(""+(connection!=null));


         //LifecyCle
//        Lifecycle lifecycle = context.getBean(Lifecycle.class);
//        log.info(""+lifecycle.isRunning());
//        context.close();
    }
    public static void createTable(Connection connection) throws SQLException {
        connection.createStatement().execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null, primary key(id))");
    }
}
