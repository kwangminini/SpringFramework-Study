package kr.co.fastcampus.cli.di;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class B {
    boolean condition;
    public int calc(){
        if(condition){
            return 1;
        }else{
            return 0;
        }
    }
}
