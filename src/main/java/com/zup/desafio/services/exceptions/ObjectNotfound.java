package com.zup.desafio.services.exceptions;

public class ObjectNotfound extends RuntimeException{

    public ObjectNotfound(String msg){
        super(msg);
    }

    public ObjectNotfound(String msg, Throwable cause){
        super(msg, cause);
    }

}
