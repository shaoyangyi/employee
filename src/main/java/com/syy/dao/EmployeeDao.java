package com.syy.dao;

import com.syy.project.Department;
import com.syy.project.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees=null;

    @Autowired
    private DepartmentDao departmentDao;

    //    模拟数据库中的数据
    static {
        employees=new HashMap<Integer, Employee>();
        employees.put(101,new Employee(1001,"AA","123456@163.com",1,new Department(101,"教学部")));
        employees.put(102,new Employee(1002,"AA","123456@163.com",1,new Department(101,"财务部")));
        employees.put(103,new Employee(1003,"AA","123456@163.com",0,new Department(101,"学工部")));
        employees.put(104,new Employee(1004,"AA","123456@163.com",0,new Department(101,"后勤部")));
        employees.put(105,new Employee(1005,"AA","123456@163.com",1,new Department(101,"体育部")));
    }

    //主键自增
    //增加一个员工

    private static Integer initId=1;
    public void save(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

//    查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

//    通过id查找员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

//    通过id删除员工
    public void delete(Integer id){
        employees.remove(id);
    }


}
