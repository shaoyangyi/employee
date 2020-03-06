package com.syy.controller;

import com.syy.dao.EmployeeDao;
import com.syy.project.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees=employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "list";
    }
}
