package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Slf4j
@Configuration
//@ComponentScan(basePackageClasses = Main.class, excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = B.class))
@ComponentScan(basePackageClasses = Main.class, excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,pattern = "kr.co.fastcampus.cli.B"))
public class Main {

    public static void main(String[] args)  {
        log.info("hello");
        //ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class); //class넣는게 실수를 줄여준다.
        //Dao2 dao2 = context.getBean(Dao2.class);
        context.scan("kr.co.fastcampus.cli");
        B b = context.getBean(B.class);
        log.info(""+b);
        //dao2.run();
//        ConnectionFactory factory = context.getBean(ConnectionFactory.class);
//        Connection connection = factory.getConnection();
//        log.info(""+(connection!=null));


         //LifecyCle
//        Lifecycle lifecycle = context.getBean(Lifecycle.class);
//        log.info(""+lifecycle.isRunning());
//        context.close();
    }
}
