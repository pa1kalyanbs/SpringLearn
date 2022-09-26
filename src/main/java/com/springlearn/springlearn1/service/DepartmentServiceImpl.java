package com.springlearn.springlearn1.service;

import com.springlearn.springlearn1.entity.Department;
import com.springlearn.springlearn1.errorHandlling.DepartmentErrorHandlling;
import com.springlearn.springlearn1.repository.DeparmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements  DepartmentService{

    @Autowired
    private DeparmentRepository deparmentRepository;
    @Override
    public Department SaveDetails(Department department) {
        return deparmentRepository.save(department);
    }

    @Override
    public List<Department> showDepartment() {
        return deparmentRepository.findAll();
    }

    @Override
    public Department featchById(Long id) throws DepartmentErrorHandlling {

        Optional<Department> department = deparmentRepository.findById(id);
        if(!department.isPresent()){
            throw new DepartmentErrorHandlling("Department Not Available");
        }

        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long id) {
        deparmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department depDB = deparmentRepository.findById(id).get();

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getName()) && !"".equalsIgnoreCase(department.getName())){
            depDB.setName(department.getName());
        }

        return deparmentRepository.save(depDB);

    }

    @Override
    public Department featchDepatmentByName(String name) {
        return deparmentRepository.findByDepartmentNameIgnoreCase(name);
    }
}
