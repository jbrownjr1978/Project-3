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
                    " (product_id, product_Name, price, sold_by) " +
                    "values (?, ?, ?, ?)");
            ps.setInt(1, p.getProductId());
            ps.setString(2, p.getProductName());
            ps.setDouble(3, p.getPrice());
            ps.setInt(4, p.getSoldBy());
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
                int productId = rs.getInt("product_id");
                String productName = rs.getString("product_Name");
                double price = rs.getInt("price");
                int soldBy = rs.getInt("sold_by");
                Product p = new Product(productId, productName, price, soldBy);
                resultProducts.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultProducts;
    }
    public Product getProductById(int id){
        try{
            PreparedStatement ps = conn.prepareStatement("select * from Product where product_id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int productId = rs.getInt("product_id");
                String productName = rs.getString("product_Name");
                double price = rs.getInt("price");
                int soldBy = rs.getInt("sold_by");
                Product p = new Product(productId, productName, price, soldBy);
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
                int soldBy = rs.getInt("sold_by");
                Product p = new Product(productId, productName, price, soldBy);
                resultProducts.add(p);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return resultProducts;
    }


}








