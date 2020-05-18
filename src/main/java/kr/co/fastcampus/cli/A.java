package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Component
//@Named("a")
public class A {
    //private B b;

    //@Autowired spring VERSION UP
//    @Autowired
//    public A(B b){
//        this.b = b;
//    }

//    @Autowired
//    public void setB(B b) {
//        this.b = b;
//    }

    //autowired 필드 사용법
//    @Autowired private B b;
//
//    @PostConstruct
//    void init(){
//        log.info(""+b);
//    }

    //@Autowired @Qualifier("b2") private B b;
   // @Resource(name = "b1") private B b;
    @Autowired private B b;
    @Autowired private ApplicationContext context;
    //@Value("${catalog.name}") String catalogName;

    @PostConstruct
    void init(){
        log.error("A post construct");
    }

    @PreDestroy
    void destroy(){

    }
}
