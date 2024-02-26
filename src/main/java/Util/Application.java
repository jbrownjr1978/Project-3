package Util;
import Controller.Controller;
import DAO.SellerDAO;
import DAO.ProductDAO;
import Service.ProductService;
import Service.SellerService;
import Util.ConnectionSingleton;
import io.javalin.Javalin;

import java.sql.Connection;

public class Application {
    public static void main(String[] args) {
        Connection conn = ConnectionSingleton.getConnection();
        SellerDAO sellerDAO = new SellerDAO(conn);
        ProductDAO productDAO = new ProductDAO(conn);
        SellerService sellerService = new SellerService(sellerDAO);
        ProductService productService = new ProductService(productDAO);
        Controller controller = new Controller(sellerService, productService);

        Javalin api = controller.getAPI();
        api.start(9007);
    }


}