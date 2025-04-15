package edu.semo.cs533.bx1.service;

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
public class MaintenanceServiceTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private MaintenanceService maintenanceService;

    @Test
    void resetDatabaseTest() {
        maintenanceService.resetDatabase();

        verifyCategory();
    }

    private void verifyCategory() {
        Optional<Category> retrievedProduct = categoryRepository.findById(1L);
        assertThat(retrievedProduct).isPresent();
        assertThat(retrievedProduct.get().getName()).isEqualTo("TVs");
    }
}
