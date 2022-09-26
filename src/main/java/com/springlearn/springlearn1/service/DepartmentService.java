package com.springlearn.springlearn1.service;

import com.springlearn.springlearn1.entity.Department;
import com.springlearn.springlearn1.errorHandlling.DepartmentErrorHandlling;

import java.util.List;

public interface DepartmentService {
    public Department SaveDetails(Department department);

   public List<Department> showDepartment();

   public  Department featchById(Long id) throws DepartmentErrorHandlling;

   public void deleteDepartmentById(Long id);

   public Department updateDepartment(Long id, Department department);

   public Department featchDepatmentByName(String name);
}
