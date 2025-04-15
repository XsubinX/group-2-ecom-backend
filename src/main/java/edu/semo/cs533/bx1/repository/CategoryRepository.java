package edu.semo.cs533.bx1.repository;

import edu.semo.cs533.bx1.dao.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
