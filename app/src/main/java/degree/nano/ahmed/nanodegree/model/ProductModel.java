package degree.nano.ahmed.nanodegree.model;

/**
 * Created by sand on 17/01/17.
 */
public class ProductModel {

    String productName;
    String productDescription;
    String productUrl;
    String price;
    double latitude;
    double longitude;
    String mobile;
    String email;

    public ProductModel() {
    }

    public ProductModel(String productName, String productDescription, String productUrl, String price) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productUrl = productUrl;
        this.price = price;
    }

    public ProductModel(String productName, String productDescription, String productUrl, String price, double longitude, double latitude) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productUrl = productUrl;
        this.price = price;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public ProductModel(String productName, String productDescription, String productUrl, String price,String email,
                        String mobile,double longitude, double latitude) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productUrl = productUrl;
        this.price = price;
        this.latitude = latitude;
        this.longitude = longitude;
        this.mobile = mobile;
        this.email = email;

    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
