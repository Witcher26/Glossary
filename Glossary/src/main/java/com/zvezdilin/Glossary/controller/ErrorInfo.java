package com.zvezdilin.Glossary.controller;

public class ErrorInfo extends RuntimeException {
    private Exception e;

    public ErrorInfo(){
        super();
    }

    public ErrorInfo(Exception e){
        this.e=e;
    }

    public ErrorInfo(String str) {
        super(str);
    }

    public String getMessage() {
        return "Unexpected error";
    }

}