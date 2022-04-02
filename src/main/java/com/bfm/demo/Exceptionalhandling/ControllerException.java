package com.bfm.demo.Exceptionalhandling;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class ControllerException extends RuntimeException{
    private String errorCode;
    private String msg;
    //private static final long serialVersionUID = 2L;
    public ControllerException(){

    }
    public ControllerException(String e, String msg){
        super();
        this.errorCode = e;
        this.msg = msg;
    }
}
