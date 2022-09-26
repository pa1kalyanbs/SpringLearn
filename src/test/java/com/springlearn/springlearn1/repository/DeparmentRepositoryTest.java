package com.springlearn.springlearn1.repository;

import com.springlearn.springlearn1.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DeparmentRepositoryTest {

    @Autowired
    private DeparmentRepository deparmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("Computer Science")
                .departmentAddress("Mahadevapura")
                .departmentCode("CS-01")
                .build();

        testEntityManager.persist(department);
    }

    @Test
    public void findById_ThenRetuenDepartment(){
        Department department = deparmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "Computer Science");
    }
}