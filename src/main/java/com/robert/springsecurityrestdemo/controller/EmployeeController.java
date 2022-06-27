package com.robert.springsecurityrestdemo.controller;

import com.robert.springsecurityrestdemo.entity.Employee;
import com.robert.springsecurityrestdemo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@AllArgsConstructor

public class EmployeeController {
    private final EmployeeService service;

    @RequestMapping(value="/employees", method = RequestMethod.GET)
    Page<Employee> all(
            @RequestParam(value="page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value="count", required = false, defaultValue = "10") Integer count
    ){
        return service.all(page, count);
    }

    @RequestMapping(value="/employees", method = RequestMethod.POST)
    Employee add(
            @RequestBody Employee employee,
            @RequestBody Map<String, Object> payload
    ){
        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(
                payload.get("username"),
                payload.get("password")
        );

        SecurityContext sc = SecurityContextHolder.getContext();

        sc.getAuthentication().isAuthenticated();
        return service.add(employee);
    }

    @RequestMapping(value="/employees/{id}", method=RequestMethod.GET)
    Employee one(@PathVariable Long id){
        return service.one(id);
    }

}