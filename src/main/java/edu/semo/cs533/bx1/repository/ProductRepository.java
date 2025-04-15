package edu.semo.cs533.bx1.repository;

import edu.semo.cs533.bx1.dao.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
