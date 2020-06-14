//package kr.co.fastcampus.cli;
//
//import kr.co.fastcampus.cli.config.AppConfig;
//import kr.co.fastcampus.cli.controller.MemberController;
//import kr.co.fastcampus.cli.dao.MemberDao;
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//@Slf4j
////@Configuration
////@ComponentScan(basePackageClasses = Main.class, excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = B.class))
////@ComponentScan(basePackageClasses = Main.class, excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,pattern = "kr.co.fastcampus.cli.B"))
//public class Main {
//
//    public static void main(String[] args) throws SQLException {
//        log.info("hello");
//        //ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
//        //ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dao.xml"); //class넣는게 실수를 줄여준다.
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.register(AppConfig.class); //Configuration 설정
//        context.refresh();
//        createTable(context.getBean(DataSource.class).getConnection());
//
//        System.out.println("=================== 사용자의 username, password를 입력해주세요. =====================");
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("username:");
//        String username = scanner.nextLine();
//        System.out.println("password:");
//        String password = scanner.nextLine();
//
//        MemberController controller = context.getBean(MemberController.class);
//        controller.insert(username,password);
//        controller.print();
//
////        MyService service = context.getBean(MyService.class);
////        service.check();
//
//        //Dao2 dao2 = context.getBean(Dao2.class);
//        //context.scan("kr.co.fastcampus.cli");
//        //B b = context.getBean(B.class);
//        /*Dao b = context.getBean(Da o.class);
//        b.run();
//        log.info(""+b);*/
//        context.close();
//        //dao2.run();
////        ConnectionFactory factory = context.getBean(ConnectionFactory.class);
////        Connection connection = factory.getConnection();
////        log.info(""+(connection!=null));
//
//
//         //LifecyCle
////        Lifecycle lifecycle = context.getBean(Lifecycle.class);
////        log.info(""+lifecycle.isRunning());
////        context.close();
//    }
//    public static void createTable(Connection connection) throws SQLException {
//        connection.createStatement().execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null, primary key(id))");
//    }
//}
