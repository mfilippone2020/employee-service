package com.example.employeeservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeServiceController {
    private static Map<String, List<Employee>> emplyDB = new HashMap<String, List<Employee>>();
    static {
        emplyDB = new HashMap<String, List<Employee>>();
        List<Employee> lst = new ArrayList<Employee>();
        Employee emp = new Employee("Tony Stark", "CEO");
        lst.add(emp);
        emp = new Employee("Peter Parker", "Analyst");
        lst.add(emp);
        emplyDB.put("Employees", lst);
    }

    @RequestMapping(value = "/getEmployees/{employeelist}", method = RequestMethod.GET)
    public  List<Employee> getEmployees(@PathVariable String employeelist){
        System.out.println("Getting Employee details from" + employeelist);

        List<Employee> employeeList = emplyDB.get(employeelist);
        if(employeeList == null){
            employeeList = new ArrayList<Employee>();
            Employee emp = new Employee("Not Found","N/A");
            employeeList.add(emp);
        }
        return employeeList;
    }

}
