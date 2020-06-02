package kr.co.fastcampus.cli.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

public class Main {
    public static void main(String[] args) {
//        Pojo pojo = new SimplePojo();
//        pojo.foo();
        ProxyFactory factory = new ProxyFactory(new SimplePojo());
        factory.addInterface(Pojo.class);
        factory.addAdvice(new RetryAdvice());
        Pojo pojo = (Pojo) factory.getProxy();
        System.out.println(">>>");
        pojo.foo();
        System.out.println(">>>");

    }
}

class RetryAdvice implements MethodInterceptor{ //spring에서 제공하는 일종의 AOP 
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
         //return null; // return null 하면 프록시 사이의 함수가 동작 안한다
        System.out.println("before"); //이런식으로 before , after 로직도 구현 가능
        Object proceed= methodInvocation.proceed();
        System.out.println("after");
        return proceed; //이렇게 리턴을 해야 프록시 사이의 함수가 작동
    }
}
interface Pojo{
    void foo();
}
class SimplePojo implements Pojo{
    public void foo(){
        System.out.println("run foo");
    }
}
