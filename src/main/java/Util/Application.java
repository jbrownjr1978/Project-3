package Util;

import Controller.ProductController;
import DAO.ProductDAO;
import DAO.SellerDAO;
import Service.ProductService;
import Service.SellerService;
import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;

public class Main {
    public static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Connection conn = ConnectionSingleton.getConnection();
        SellerDAO sellerDAO = new SellerDAO(conn);
        ProductService productService = null;
        ProductDAO productDAO = new ProductDAO(conn, productService);
        //       ProductService productService = new ProductService(productDAO);
//        ModuleLayer.Controller controller = new ModuleLayer.Controller(sellerService, productService);
//        ProductController productController = new ProductController(sellerService,productService);
        SellerService sellerService = new SellerService(sellerDAO);
        productService = new ProductService(productDAO, sellerService);
        ProductController productController = new ProductController(sellerService, productService);
        Javalin api = productController.getAPI();
        api.start(9002);
    }
}

