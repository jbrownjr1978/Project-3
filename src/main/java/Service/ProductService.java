package Service;
import Exceptions.ProductAlreadyExistsException;
import Exceptions.ProductException;
import Model.Product;
import DAO.ProductDAO;
import java.util.List;

public class ProductService {
    ProductDAO productDAO;
    public ProductService(ProductDAO productDAO){
        this.productDAO = productDAO;
    }
    public void saveProduct(Product p) throws ProductAlreadyExistsException {
        long id = p.getProductId();
//        If no product with that id was found - insert the product
        if(productDAO.getProductById(id) == null){
            productDAO.insertProduct(p);
        }else{
            throw new ProductAlreadyExistsException("product with id "+id+" already exists");
        }
//        Otherwise, throw an exception to inform the controller that there was an
//        issue inserting the painting

    }
    public List<Product> getProductsByPrice(){
        return productDAO.getProductsOrderedByPrice();
    }
    public List<Product> getAllProducts(){
        return productDAO.getAllProducts();
    }

    public Product addProduct(Product p) throws ProductException {
        if (p.getPrice() <= 0 || p.getProductName() == null || p.getSellerName() == null){
            throw new ProductException("price, sellerName, and productName fields must not be empty");

        }

        long id = (long) (Math.random() * Long.MAX_VALUE);
        p.setProductId(id);
        productDAO.getAllProducts().add(p);
        return p;

    }

}
