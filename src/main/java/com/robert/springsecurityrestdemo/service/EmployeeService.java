package com.robert.springsecurityrestdemo.service;

import com.robert.springsecurityrestdemo.entity.Employee;
import com.robert.springsecurityrestdemo.ex.EmployeeNotFoundException;
import com.robert.springsecurityrestdemo.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public Page<Employee> all(){
        return all(0, 10);
    }

    public Page<Employee> all(int page, int size){
        Pageable paging = PageRequest.of(page, size);

        return repository.findAll(paging);
    }

    public Employee add(Employee employee){
        return repository.save(employee);
    }

    public Employee one(Long id){
        return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

}