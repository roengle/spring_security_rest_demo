package com.robert.springsecurityrestdemo.ex;

public class EmployeeNotFoundException extends RuntimeException{
    private Long id;

    public EmployeeNotFoundException(Long id){
        super("Employee not found with id " + id);
    }

    public Long getId(){
        return id;
    }
}
