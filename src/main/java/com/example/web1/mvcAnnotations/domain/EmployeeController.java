package com.example.web1.mvcAnnotations.domain;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
public class EmployeeController {

  private final List<Employee> employees = new ArrayList<Employee>();

//  Task 2.1: Add a new employee
  @PostMapping("/employees/add")
  @ResponseBody
  @ResponseStatus(HttpStatus.CREATED)
  //  https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#successful_responses
  public Employee addNewEmployee(@RequestBody Employee employee){
    employees.add(employee);
    return employee;
  }

//  Task 2.2: List all employees
//  @RequestParam - url related
  @GetMapping("/employees")
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public List<Employee> getEmployees(@RequestParam(required=false) Integer limit) {
    if(limit == null){
      return employees;
    }
    return employees.subList(0, limit);
  }
}
