package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args)  {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
        //Dao2 dao2 = context.getBean(Dao2.class);
        //dao2.run();
//        ConnectionFactory factory = context.getBean(ConnectionFactory.class);
//        Connection connection = factory.getConnection();
//        log.info(""+(connection!=null));
        Lifecycle lifecycle = context.getBean(Lifecycle.class);
        log.info(""+lifecycle.isRunning());
        context.close();
    }
}
