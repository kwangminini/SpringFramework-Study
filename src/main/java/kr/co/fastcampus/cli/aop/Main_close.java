//package kr.co.fastcampus.cli.aop;
//
//import kr.co.fastcampus.cli.Dao;
//import org.aopalliance.intercept.MethodInterceptor;
//import org.aopalliance.intercept.MethodInvocation;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//public class Main {
//    public static void main(String[] args) throws SQLException {
////        Pojo pojo = new SimplePojo();
////        pojo.foo();
////        ProxyFactory factory = new ProxyFactory(new SimplePojo());
////        factory.addInterface(Pojo.class);
////        factory.addAdvice(new RetryAdvice());
////        Pojo pojo = (Pojo) factory.geAtProxy();
////        System.out.println(">>>");
////        pojo.foo();
////        System.out.println(">>>");
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
////        Service bean = context.getBean(Service.class);
////        bean.log();
//        createTable(context.getBean(Connection.class));
//        Dao dao = context.getBean(Dao.class);
//        dao.insert();
//        dao.print();
//
//        context.close();
//
//    }
//    public static void createTable(Connection connection) throws SQLException{
//        connection.createStatement().execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null, primary key(id))");
//    }
//}
//
//class RetryAdvice implements MethodInterceptor{ //spring에서 제공하는 일종의 AOP
//    @Override
//    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
//         //return null; // return null 하면 프록시 사이의 함수가 동작 안한다
//        System.out.println("before"); //이런식으로 before , after 로직도 구현 가능
//        Object proceed= methodInvocation.proceed();
//        System.out.println("after");
//        return proceed; //이렇게 리턴을 해야 프록시 사이의 함수가 작동
//    }
//}
//interface Pojo{
//    void foo();
//}
//class SimplePojo implements Pojo{
//    public void foo(){
//        System.out.println("run foo");
//    }
//}
