package Controller;
import Service.ProductService;
import Service.SellerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;
import Exceptions.ProductAlreadyExistsException;
import Exceptions.SellerNotFoundException;
import Model.Seller;
import Model.Product;


import java.util.List;


public class Controller {

    SellerService sellerService;
    ProductService productService;
    public Controller(SellerService sellerservice, ProductService productService){
        this.sellerService = sellerservice;
        this.productService = productService;
    }

    public Javalin getAPI() {
        Javalin app = Javalin.create();
        app.get("seller", context -> {
            List<Seller> sellerList = sellerService.getAllSeller();
            context.json(sellerList);
        });
        app.post("seller", context -> {
            ObjectMapper om = new ObjectMapper();
            Seller s = om.readValue(context.body(), Seller.class);
            sellerService.saveSeller(s);
            context.status(201);
        });
        app.get("seller/{id}", context -> {
            int id = Integer.parseInt(context.pathParam("id"));
            try{
                Seller s = sellerService.getSellerById(id);
                context.json(s);
            }catch (SellerNotFoundException e){
                context.status(404);
            }
        });
        app.post("product", context -> {
            ObjectMapper om = new ObjectMapper();
            Product p = om.readValue(context.body(), Product.class);
            Product newProduct = productService.addProduct(p);
            context.status(201);
            context.json(newProduct);

        });
        /*
        I want to give the client an option for additional paramters to a general
        search - pagination, ordering, filtering, etc
        Grab a query param (the part after ?), and check if it matches some value
        to change the behavior of my api
         */
        app.get("product/byprice", context -> {
            String order = context.queryParam("orderedBy");
            if(order!= null && order.equals("price")){
                List<Product> products = productService.getProductsByPrice();
                context.json(products);
            }
            else {
                List<Product> products = productService.getAllProducts();
                context.json(products);
            }
        });

        app.get("product", context -> {
            System.out.println("Am I working?");
           List<Product> productList = productService.getAllProducts();
            context.json(productList);
        });

        return app;
    }




}
