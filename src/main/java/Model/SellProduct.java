package Model;

public class SellProduct {
    private int id;
    private String name;
    private int price;
    private float discount;
    private int importAmount;
    private int exportAmount;
    private String picture;
    private String properties;

    private String productType;
    private String maker;

    public SellProduct(String name, int price, float discount, int importAmount, int exportAmount,String picture, String properties, String productType,String maker) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.importAmount = importAmount;
        this.exportAmount = exportAmount;
        this.picture=picture;
        this.properties = properties;
        this.productType=productType;
        this.maker = maker;
    }

    public SellProduct(int id, String name, int price, float discount, int importAmount, int exportAmount,String picture, String properties,String productType,String maker) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.importAmount = importAmount;
        this.exportAmount = exportAmount;
        this.picture=picture;
        this.properties = properties;
        this.productType=productType;
        this.maker = maker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getImportAmount() {
        return importAmount;
    }

    public void setImportAmount(int importAmount) {
        this.importAmount = importAmount;
    }

    public int getExportAmount() {
        return exportAmount;
    }

    public void setExportAmount(int exportAmount) {
        this.exportAmount = exportAmount;
    }


    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }
}


