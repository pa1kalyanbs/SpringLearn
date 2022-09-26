package com.springlearn.springlearn1.service;

import com.springlearn.springlearn1.entity.Department;
import com.springlearn.springlearn1.repository.DeparmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DeparmentRepository deparmentRepository;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("ECE")
                        .departmentAddress("Bengalore")
                        .departmentCode("EC-06")
                        .build();

        Mockito.when(deparmentRepository.findByDepartmentNameIgnoreCase("ECE")).thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on valid Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String DepName = "ECE";
        Department found =
                departmentService.featchDepatmentByName(DepName);

        assertEquals(DepName, found.getDepartmentName());
    }
}