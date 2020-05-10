package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;

@Slf4j
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

    @Autowired @Qualifier("b2") private B b;
    //@Resource(name = "b1") private B b;
    @Autowired private ApplicationContext context;
    @Value("${catalog.name}") String catalogName;

    @PostConstruct
    void init(){
        log.info(""+context);
    }

}
