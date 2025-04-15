package edu.semo.cs533.bx1.product;


import edu.semo.cs533.bx1.dao.Category;
import edu.semo.cs533.bx1.repository.CategoryRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;

    @Test
    public void testSaveAndFindById() {
        Category tvCategory = new Category();
        tvCategory.setName("TVs");

        repository.save(tvCategory);

        Optional<Category> retrievedProduct = repository.findById(1L);
        assertThat(retrievedProduct).isPresent();
        assertThat(retrievedProduct.get().getName()).isEqualTo(tvCategory.getName());
    }
}
