package edu.semo.cs533.bx1.product;


import edu.semo.cs533.bx1.dao.Category;
import edu.semo.cs533.bx1.dao.Product;
import edu.semo.cs533.bx1.repository.CategoryRepository;
import edu.semo.cs533.bx1.repository.ProductRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testSaveAndFindById() {
        Category tvCategory = new Category();
        tvCategory.setName("TVs");
        Category category = categoryRepository.save(tvCategory);

        Product product = new Product("Hisense", "Hisense Class A4 Series Full HD 1080P Smart Roku TV ",
                199.99, category,
                "https://i.postimg.cc/w7TQhw5P/hisense.webp");
        productRepository.save(product);

        Optional<Product> retrievedProduct = productRepository.findById(1L);
        assertThat(retrievedProduct).isPresent();
        assertThat(retrievedProduct.get().getName()).isEqualTo(product.getName());
    }
}
