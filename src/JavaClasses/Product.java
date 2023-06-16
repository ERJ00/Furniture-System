package JavaClasses;

public class Product {
    public int ID;
    private int price;
    private int quantity;
    private String productName;
    private String brand;
    private String description;
    private String category;
    private String supplier;
    private String date;

    public Product() {
        // Default constructor
    }

    public Product(Product other) {
        // Copy constructor
        this.ID = other.ID;
        this.price = other.price;
        this.quantity = other.quantity;
        this.productName = other.productName;
        this.brand = other.brand;
        this.description = other.description;
        this.category = other.category;
        this.supplier = other.supplier;
        this.date = other.date;
    }

    // Getters and Setters

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}