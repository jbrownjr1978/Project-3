package Model;
import java.util.Objects;

public class Product {
    public int productId;
    public String productName;
    public double price;
    public int soldBy;

    public Product() {

    }

    public Product(int productId, String productName, double price, int soldBy) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.soldBy = soldBy;
    }
    public int getProductId() {
        return productId;
    }

    public void setProductId(int paintingId) {
        this.productId = paintingId;
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

    public int getSoldBy() {
        return soldBy;
    }

    public void setSoldBy(int soldBy) {
        this.soldBy = soldBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && Double.compare(product.price, price) == 0 && soldBy == product.soldBy && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, price, soldBy);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", soldBy=" + soldBy +
                '}';
    }
}

