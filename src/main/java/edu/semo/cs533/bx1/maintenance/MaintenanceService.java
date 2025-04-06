package edu.semo.cs533.bx1.maintenance;

import edu.semo.cs533.bx1.product.Product;
import edu.semo.cs533.bx1.product.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceService {

    private final ProductRepository productRepository;

    @Autowired
    public MaintenanceService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void resetDatabase() {

        productRepository.deleteAll();

        List<Product> products = new ArrayList<>() {
            {
                add(new Product("Hisense", "Hisense Class A4 Series Full HD 1080P Smart Roku TV ", 199.99, "TVs",
                        "https://i.postimg.cc/w7TQhw5P/hisense.webp"));
                add(new Product("Insignia", "Insignia™ - 32 Class F20 Series LED Full HD Smart Fire TV", 135.99,
                        "TVs",
                        "https://i.postimg.cc/MvPbt1dG/Insignia.webp"));
                add(new Product("LG", "LG - Class LED Full HD Smart TV with webOS", 99.99, "TVs",
                        "https://i.postimg.cc/dhhRfDxj/lg.webp"));
                add(new Product("Roku", "Roku - 32 Class Select Series Full HD Smart RokuTV", 129.99, "TVs",
                        "https://i.postimg.cc/w1n5YgK8/roku.webp"));
                add(new Product("Samsung™ - 32", "Samsung - 32 Class Q60D Series QLED 4K Smart Tizen TV ", 475.99,
                        "TVs",
                        "https://i.postimg.cc/TymVRFGy/samsung.webp"));
                add(new Product("TCL™ - 32", "TCL - 32 Class S3 S - Class LED Full HD Smart TV with Google TV",
                        299.99,
                        "TVs",
                        "https://i.postimg.cc/gXWvrskg/tcl.webp"));
                add(new Product("Toshiba", "Toshiba - 32 Class V35 Series LED HD Smart Fire TV", 149.99, "TVs",
                        "https://i.postimg.cc/0M07SSzP/toshiba.webp"));
            }

        };

        productRepository.saveAll(products);
    }

}