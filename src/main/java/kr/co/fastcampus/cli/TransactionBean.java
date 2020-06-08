//package kr.co.fastcampus.cli;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
////@Aspect
//public class TransactionBean {
////    public void log(){
////        log.error(">>>aop Log");
////    }
////    public void beforeLog(){
////        log.error(">>>before aop log");
////    }
////    public void afterLog(){
////        log.error(">>>afterLog aop log");
////    }
////    public void afterReturningLog(){
////        log.error(">>>afterReturningLog aop log");
////    }
////    public void afterThrowingLog(){
////        log.error(">>>afterThrowingLog aop log");
////    }
//
//
////    private Connection connection;
////    public TransactionBean(Connection connection) {
////        this.connection = connection;
////    }
////
////    @Pointcut("execution(* kr.co.fastcampus.cli.Dao.insert(..))")
////    public void transcationPointcut(){}
////
////    @Around("transcationPointcut()")
////    public Object aroundLog(ProceedingJoinPoint pjp) throws SQLException {
////        log.error(">>>before aop transcation");
////        connection.setAutoCommit(false);
////        try {
////            Object proceed = pjp.proceed();
////            log.error(">> commit");
////            connection.commit();
////
////            return proceed;
////        } catch (Throwable throwable) {
////            log.error(">> rollback");
////            connection.rollback();
////        }
////        log.error(">>>after aop transcation");
////        return null;
////    }
//}
