package edu.semo.cs533.bx1.product;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>() {
        {
            add(new Product(1L, "Hisense", "Hisense Class A4 Series Full HD 1080P Smart Roku TV ", "TVs",
                    "https://i.postimg.cc/w7TQhw5P/hisense.webp"));
            add(new Product(1L, "Insignia", "Insignia™ - 32 Class F20 Series LED Full HD Smart Fire TV", "TVs",
                    "https://i.postimg.cc/MvPbt1dG/Insignia.webp"));
            add(new Product(1L, "LG", "LG - Class LED Full HD Smart TV with webOS", "TVs",
                    "https://i.postimg.cc/dhhRfDxj/lg.webp"));
            add(new Product(1L, "Roku", "Roku - 32 Class Select Series Full HD Smart RokuTV", "TVs",
                    "https://i.postimg.cc/w1n5YgK8/roku.webp"));
            add(new Product(1L, "Samsung™ - 32", "Samsung - 32 Class Q60D Series QLED 4K Smart Tizen TV ", "TVs",
                    "https://i.postimg.cc/TymVRFGy/samsung.webp"));
            add(new Product(1L, "TCL™ - 32", "TCL - 32 Class S3 S - Class LED Full HD Smart TV with Google TV", "TVs",
                    "https://i.postimg.cc/gXWvrskg/tcl.webp"));
            add(new Product(1L, "Toshiba", "Toshiba - 32 Class V35 Series LED HD Smart Fire TV", "TVs",
                    "https://i.postimg.cc/0M07SSzP/toshiba.webp"));
        }
    };

    public List<Product> list() {
        return products;
    }

    public int add(Product product) {

        if (products.contains(product)) {
            System.out.println("found a duplicate");
            return -1;
        }
        products.add(product);
        return 0;
    }
}
