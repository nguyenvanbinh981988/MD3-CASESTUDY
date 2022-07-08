package Model;

public class SellList {
    private int id;
    private int exportAmount;
    private Customer customer;
    private SellProduct sellProduct;
    private Admin admin;
    private String statusCustomer;
    private String statusAdmin;

    public SellList(int exportAmount, Customer customer, SellProduct sellProduct, Admin admin, String statusCustomer, String statusAdmin) {
        this.exportAmount = exportAmount;
        this.customer = customer;
        this.sellProduct = sellProduct;
        this.admin = admin;
        this.statusCustomer = statusCustomer;
        this.statusAdmin = statusAdmin;
    }

    public SellList(int id, int exportAmount, Customer customer, SellProduct sellProduct, Admin admin, String statusCustomer, String statusAdmin) {
        this.id = id;
        this.exportAmount = exportAmount;
        this.customer = customer;
        this.sellProduct = sellProduct;
        this.admin = admin;
        this.statusCustomer = statusCustomer;
        this.statusAdmin = statusAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExportAmount() {
        return exportAmount;
    }

    public void setExportAmount(int exportAmount) {
        this.exportAmount = exportAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public SellProduct getSellProduct() {
        return sellProduct;
    }

    public void setSellProduct(SellProduct sellProduct) {
        this.sellProduct = sellProduct;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdminId(Admin admin) {
        this.admin = admin;
    }

    public String getStatusCustomer() {
        return statusCustomer;
    }

    public void setStatusCustomer(String statusCustomer) {
        this.statusCustomer = statusCustomer;
    }

    public String getStatusAdmin() {
        return statusAdmin;
    }

    public void setStatusAdmin(String statusAdmin) {
        this.statusAdmin = statusAdmin;
    }
}
