package kr.co.fastcampus.cli.aop;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Service {
    public void log(){
        log.error(">>>aop Log");
    }
    public void beforeLog(){
        log.error(">>>before aop log");
    }
    public void afterLog(){
        log.error(">>>after aop log");
    }
    public void afterReturningLog(){
        log.error(">>>afterReturningLog aop log");
    }
    public void afterThrowingLog(){
        log.error(">>>afterThrowingLog aop log");
    }
}
