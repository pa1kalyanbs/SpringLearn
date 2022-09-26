package com.springlearn.springlearn1.controller;

import com.springlearn.springlearn1.entity.Department;
import com.springlearn.springlearn1.errorHandlling.DepartmentErrorHandlling;
import com.springlearn.springlearn1.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepatmentController.class)
class DepatmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp(){
        department = Department.builder()
                .departmentName("IT")
                .departmentAddress("Bengalore")
                .departmentCode("IT-06")
                .departmentId(1L)
                .name("pavan")
                .build();
    }

    @Test
    void saveDetails() throws Exception {
        Department Inputdepartment = Department.builder()
                                        .departmentName("IT")
                                        .departmentAddress("Bengalore")
                                        .departmentCode("IT-06")
                                        .name("pavan")
                                        .build();
        Mockito.when(departmentService.SaveDetails(Inputdepartment)).thenReturn(department);
        //then you will call the endpoints
        mockMvc.perform(MockMvcRequestBuilders.post("/department").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "\t\"departmentName\":\"IT\",\n" +
                "\t\"departmentAddress\":\"Bengalore\",\n" +
                "\t\"departmentCode\":\"IT-06\",\n" +
                "\t\"name\":\"pavan\"\n" +
                "}")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void featchById() throws Exception {
        Mockito.when(departmentService.featchById(1L)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/department/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName")
                        .value(department.getDepartmentName()));
    }
}