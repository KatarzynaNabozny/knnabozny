package com.kodilla.hibernate.invoice.dao;
import com.kodilla.hibernate.invoice.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface ProductDao extends CrudRepository<Product,Integer> {
    List<Product>findProductByName(String name);
}
