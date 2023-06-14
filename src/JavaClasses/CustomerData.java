package JavaClasses;


//    category
//    product name
//    quantity
//    total payment
//    payment received
//    balance
//    change
//    status
//    name
//    birthday
//    contact number
//    address
//    date

public class CustomerData {
    private int quantity;
    private int totalPayment;
    private int paymentReceived;
    private int balance;
    private int change;
    private String category;
    private String productName;
    private String status;
    private String name;
    private String birthday;
    private String contactNumber;
    private String address;
    private String date;
    
    public CustomerData() {
        // Default constructor
    }

    public CustomerData(CustomerData other) {
        // Copy constructor
        
        this.quantity = other.quantity;
        this.productName = other.productName;
        this.category = other.category;
        this.date = other.date;
        this.totalPayment = other.totalPayment;
        this.paymentReceived = other.paymentReceived;
        this.balance = other.balance;
        this.change = other.change;
        this.status = other.status;
        this.name = other.name;
        this.birthday = other.birthday;
        this.contactNumber = other.contactNumber;
        this.address = other.address;
    }

    // Getters and Setters

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    public int getPaymentReceived() {
        return paymentReceived;
    }

    public void setPaymentReceived(int paymentReceived) {
        this.paymentReceived = paymentReceived;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}