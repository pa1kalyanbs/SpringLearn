package com.springlearn.springlearn1.controller;

import com.springlearn.springlearn1.entity.Department;
import com.springlearn.springlearn1.errorHandlling.DepartmentErrorHandlling;
import com.springlearn.springlearn1.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
public class DepatmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/department")
    public Department SaveDetails(@Valid @RequestBody Department department){
        return departmentService.SaveDetails(department);
    }


    @GetMapping("/department")
    public List<Department> showDepartment(){
        return departmentService.showDepartment();
    }

    @GetMapping("/department/{Id}")
    public Department featchById(@PathVariable("Id") Long Id) throws DepartmentErrorHandlling {
        return departmentService.featchById(Id);
    }

    @DeleteMapping("/department/{Id}")
    public String deleteDepartmentById(@PathVariable("Id") Long Id){
        departmentService.deleteDepartmentById(Id);
        return "Department of id: " +Id+" deleted successfully ";
    }

    @PutMapping("/department/{Id}")
    public Department updateDepartment(@PathVariable("Id") Long Id,@RequestBody Department department){
        return departmentService.updateDepartment(Id,department);
    }

    @GetMapping("/department/name/{name}")
    public Department featchDepatmentByName(@PathVariable("name") String name){
        return departmentService.featchDepatmentByName(name);
    }
}
