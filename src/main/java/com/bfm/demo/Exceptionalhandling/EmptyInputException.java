package com.bfm.demo.Exceptionalhandling;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class EmptyInputException extends RuntimeException{
    private String errorCode;
    private String msg;
    //private static final long serialVersionUID = 1L;
    public EmptyInputException(){

    }
    public EmptyInputException(String e, String msg){
        super();
        this.errorCode = e;
        this.msg = msg;
    }
}
