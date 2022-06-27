package com.robert.springsecurityrestdemo.repository;

import com.robert.springsecurityrestdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
