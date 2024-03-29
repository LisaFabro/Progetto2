public class Product {
    private static int nextId = 1;
    private int id;
    private ProductTypes type;
    private String brand;
    private String model;
    private Double displayDimension;
    private Double memoryDimension;
    private Double purchasePrice;
    private Double salesPrice;
    private String description;

    Product(ProductBuilder builder) {
        id = nextId++;
        type = builder.type;
        brand = builder.brand;
        model = builder.model;
        displayDimension = builder.displayDimension;
        memoryDimension = builder.memoryDimension;
        purchasePrice = builder.purchasePrice;
        salesPrice = builder.salesPrice;
        description = builder.description;
    }


    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", type=" + type +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", displayDimension=" + displayDimension +
                ", memoryDimension=" + memoryDimension +
                ", salesPrice=" + salesPrice +
                ", purchasePrice=" + purchasePrice +
                ", description=" + description +
                '}';
    }

    public String toStringUserList() {
        return "Device{" +
                "id=" + id +
                ", type=" + type +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", displayDimension=" + displayDimension +
                ", memoryDimension=" + memoryDimension +
                ", salesPrice=" + salesPrice +
                ", description=" + description +
                '}';
    }

    public String toStringManagerList() {
        return "Device{" +
                "id=" + id +
                ", type=" + type +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", displayDimension=" + displayDimension +
                ", memoryDimension=" + memoryDimension +
                ", salesPrice=" + salesPrice +
                ", purchasePrice=" + purchasePrice +
                ", description=" + description +
                '}';
    }

    public int getId() {
        return id;
    }

    public ProductTypes getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Double getDisplayDimension() {
        return displayDimension;
    }

    public Double getMemoryDimension() {
        return memoryDimension;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public Double getSalesPrice() {
        return salesPrice;
    }

    public String getDescription() {
        return description;
    }
}