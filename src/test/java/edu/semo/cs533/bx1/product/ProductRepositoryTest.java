package edu.semo.cs533.bx1.product;


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
    private ProductRepository repository;

    @Test
    public void testSaveAndFindById() {
        Product product = new Product("Hisense", "Hisense Class A4 Series Full HD 1080P Smart Roku TV ",
                199.99, "TVs",
                "https://i.postimg.cc/w7TQhw5P/hisense.webp");
        repository.save(product);

        Optional<Product> retrievedProduct = repository.findById(1L);
        assertThat(retrievedProduct).isPresent();
        assertThat(retrievedProduct.get().getName()).isEqualTo(product.getName());
    }
}
