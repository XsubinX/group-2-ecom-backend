package edu.semo.cs533.bx1.repository;

import edu.semo.cs533.bx1.dao.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

}
