package edu.semo.cs533.bx1.repository;

import edu.semo.cs533.bx1.dao.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
