package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args)  {

        ApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
        Dao2 dao2 = context.getBean(Dao2.class);
        dao2.run();
    }
}
