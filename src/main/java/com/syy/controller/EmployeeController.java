package com.syy.controller;

import com.syy.dao.DepartmentDao;
import com.syy.dao.EmployeeDao;
import com.syy.project.Department;
import com.syy.project.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees=employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "list";
    }

    @GetMapping("/emp")
    public String toAddpage(Model model){
//        查出所有的部门
        Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println(employee);
//        提交表单,调用底层方法保存员工信息
        employeeDao.save(employee);
        return "redirect:/emps";
    }

//        修改员工信息前查询员工信息
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id,Model model){
        Employee employee = employeeDao.getEmployeeById(id);
        System.out.println(employee);
        model.addAttribute("emp",employee);
//        查出所有的部门
        Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "update";
    }

//        保存员工信息修改
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        System.out.println(employee);
//        提交表单,调用底层方法保存员工信息
        employeeDao.save(employee);
        return "redirect:/emps";
    }



}
