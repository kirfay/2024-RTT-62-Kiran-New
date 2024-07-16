package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Long> {

    // this is a magic query in that ... spring data JPA is able to use the method name to generate the query
    Product findById(Integer id);

    @Query("select p from Product p where p.productName like concat('%', :name, '%') or p.productCode like concat('%', :name, '%')")
    List<Product> findByNameOrCode(String name);
}
