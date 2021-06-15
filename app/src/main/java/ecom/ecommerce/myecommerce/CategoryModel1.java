package ecom.ecommerce.myecommerce;

public class CategoryModel1 {
    String productDescription;
    String productID;
    String productImage;
    String productPrice;
    String productTitle;

    public CategoryModel1(String productDescription, String productID, String productImage, String productPrice, String productTitle) {
        this.productDescription = productDescription;
        this.productID = productID;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.productTitle = productTitle;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }
}
