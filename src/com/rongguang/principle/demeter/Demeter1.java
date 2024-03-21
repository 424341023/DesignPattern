package com.rongguang.principle.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rongguang
 * @version 1.0.0
 * @date 2024年03月21日 17:34:09
 * @packageName com.rongguang.principle.demeter
 * @className Demeter1
 */

// 客户端
public class Demeter1 {
    public static void main(String[] args) {
        // 创建了一个SchoolManager对象
        SchoolManager schoolManager = new SchoolManager();
        // 输出学院的员工id和学校总部的员工信息
        schoolManager.printAllEmployee(new CollegeManager());
    }
}

// 学校总部员工类
class SchoolEmployee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

// 学院的员工类
class CollegeEmployee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

// 管理学院员工的管理类
class CollegeManager {
    // 返回学院的所有员工
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<CollegeEmployee>();
        for (int i = 0; i < 10; i++) { // 这里我们增加了10个员工到list
            CollegeEmployee employee = new CollegeEmployee();
            employee.setId("学院员工ID= " + i);
            list.add(employee);
        }
        return list;
    }
}

// 学校管理类
// 分析SchoolManager类的直接朋友类有哪些？SchoolEmployee, CollegeManager
// CollegeEmployee不是直接朋友 而是一个陌生类，这样违背了迪米特原则
class SchoolManager {
    // 返回学校总部的员工
    public List<SchoolEmployee> gerAllEmployee() {
        List<SchoolEmployee> list = new ArrayList<SchoolEmployee>();
        for (int i = 0; i < 5; i++) { //这里我们增加了5个员工到 list
            SchoolEmployee schoolEmployee = new SchoolEmployee();
            schoolEmployee.setId("学校总部员工id= " + i);
            list.add(schoolEmployee);
        }
        return list;
    }

    // 该方法完成输出学校总部和学院员工信息(id)
    void printAllEmployee(CollegeManager collegeManager) {
        // 分析问题
        // 1. 这里的 CollegeEmployee 不是  SchoolManager的直接朋友
        // 2. CollegeEmployee 是以局部变量方式出现在 SchoolManager
        // 3. 违反了迪米特法则

        // 获取到学院员工
        List<CollegeEmployee> list1 = collegeManager.getAllEmployee();
        System.out.println("------------学院员工------------");
        for (CollegeEmployee e : list1) {
            System.out.println(e.getId());
        }
        // 获取到学校总部员工
        List<SchoolEmployee> list2 = this.gerAllEmployee();
        System.out.println("------------学校总部员工------------");
        for (SchoolEmployee e : list2) {
            System.out.println(e.getId());
        }
    }
}
