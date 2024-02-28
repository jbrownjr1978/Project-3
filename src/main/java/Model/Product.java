package Model;
import java.util.Objects;

public class Product {
    public long productId;
    public String productName;
    public double price;
    public String sellerName;

    public Product() {

    }

    public Product(long productId, String productName, double price, String sellerName) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.sellerName = sellerName;
    }
    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String title) {
        this.productName = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && Double.compare(product.price, price) == 0 && sellerName == product.sellerName && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, price, sellerName);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", soldBy=" + sellerName +
                '}';
    }
}

