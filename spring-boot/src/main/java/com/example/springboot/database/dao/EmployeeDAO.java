package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee, Long> {
    Employee findById(Integer id);

    @Query("SELECT e from Employee e WHERE CONCAT(e.firstName, ' ', e.lastName) LIKE CONCAT('%', :name, '%')")
    List<Employee> findByNameOrCode(String name);
}



