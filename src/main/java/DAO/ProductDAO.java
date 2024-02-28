package DAO;
import Model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    Connection conn;

    public ProductDAO(Connection conn) {
        this.conn = conn;

    }
    public void insertProduct(Product p){
        try{
            PreparedStatement ps = conn.prepareStatement("insert into Product" +
                    " (product_id, product_Name, price, seller_Name) " +
                    "values (?, ?, ?, ?)");
            ps.setLong(1, p.getProductId());
            ps.setString(2, p.getProductName());
            ps.setDouble(3, p.getPrice());
            ps.setString(4, p.getSellerName());
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
            }
    public List<Product> getAllProducts(){
        List<Product> resultProducts = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("select * from product");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                long productId = rs.getInt("product_id");
                String productName = rs.getString("product_Name");
                double price = rs.getInt("price");
                String sellerName = rs.getString("seller_name");
                Product p = new Product(productId, productName, price, sellerName);
                resultProducts.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultProducts;
    }
    public Product getProductById(long id){
        try{
            PreparedStatement ps = conn.prepareStatement("select * from Product where product_id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int productId = rs.getInt("product_id");
                String productName = rs.getString("product_Name");
                double price = rs.getInt("price");
                String sellerName = rs.getString("seller_Name");
                Product p = new Product(productId, productName, price, sellerName);
                return p;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getProductsOrderedByPrice(){
        List<Product> resultProducts = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("select * from product order by price desc limit 1 offset 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int productId = rs.getInt("product_id");
                String productName = rs.getString("product_Name");
                double price = rs.getDouble( "price");
                String sellerName = rs.getString("seller_Name");
                Product p = new Product(productId, productName, price, sellerName);
                resultProducts.add(p);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return resultProducts;
    }


}








