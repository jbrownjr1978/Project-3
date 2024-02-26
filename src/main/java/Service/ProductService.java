package Service;
import Exceptions.ProductAlreadyExistsException;
import Model.Product;
import DAO.ProductDAO;
import java.util.List;

public class ProductService {
    ProductDAO productDAO;
    public ProductService(ProductDAO productDAO){
        this.productDAO = productDAO;
    }
    public void saveProduct(Product p) throws ProductAlreadyExistsException {
        int id = p.getProductId();
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

}
