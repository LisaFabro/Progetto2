import java.util.ArrayList;
import java.util.List;

public class DemoItems {
    Product product1 = new ProductBuilder(ProductTypes.SMARTPHONE, "Samsung", "Galaxy S23", 6.6, 256.0, 550.0, 1099.99).description("Descrizione non inserita").build();
    Product product2 = new ProductBuilder(ProductTypes.SMARTPHONE, "Apple", "Iphone 14", 6.1, 128.0, 500.0, 899.99).description("Descrizione non inserita").build();
    Product product3 = new ProductBuilder(ProductTypes.SMARTPHONE, "Motorola", "Razr", 6.6, 256.0, 550.0, 1099.99).description("Descrizione non inserita").build();
    Product product4 = new ProductBuilder(ProductTypes.TABLET, "Samsung", "Galaxy Tab S9", 6.6, 256.0, 550.0, 1099.99).description("Descrizione non inserita").build();
    Product product5 = new ProductBuilder(ProductTypes.TABLET, "Apple", "iPad Pro", 11.0, 512.0, 950.0, 1449.00).description("Ottimo tablet per universitari ricchi!").build();
    Product product6 = new ProductBuilder(ProductTypes.TABLET, "Lenovo", "Tab M10", 10.1, 64.0, 50.0, 159.00).description("Descrizione non inserita").build();
    Product product7 = new ProductBuilder(ProductTypes.NOTEBOOK, "Asus", "TUF", 15.6, 512.0, 400.0, 849.99).description("Descrizione non inserita").build();
    Product product8 = new ProductBuilder(ProductTypes.NOTEBOOK, "Apple", "MacBook Air", 15.3, 256.0, 900.0, 1499.99).description("Descrizione non inserita").build();
    Product product9 = new ProductBuilder(ProductTypes.NOTEBOOK, "MSI", "Katana 17 B12VGK", 17.3, 1000.0, 1200.0, 2199.99).description("Nootbook scontatissimo! Un vero affare!").build();

    private List<Product> productList = demoItems();

    private List<Product> demoItems() {
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
        productList.add(product7);
        productList.add(product8);
        productList.add(product9);
        return productList;
    }

    public List<Product> getDeviceList() {
        return productList;
    }

}



