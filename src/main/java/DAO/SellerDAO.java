package DAO;

import Model.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellerDAO {

    Connection conn;
    public SellerDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Seller> getAllSeller(){
        List<Seller> sellerResults = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("select * from Seller");
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                int sellerId = resultSet.getInt("id");
                String sellerName = resultSet.getString("name");
                Seller s = new Seller(sellerId, sellerName);
                sellerResults.add(s);
            }
        }catch(SQLException e){
                e.printStackTrace();
            }
            return sellerResults;
        }
    public void insertSeller(Seller s){
        try{
            PreparedStatement ps = conn.prepareStatement("insert into " +
                    "Seller (seller_id, name) values (?, ?)");
            ps.setInt(1, s.getSellerId());
            ps.setString(2, s.getName());
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public Seller getSellerById(int id){
        try{
            PreparedStatement ps = conn.prepareStatement(
                    "select * from artist where artist_id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int sellerId = rs.getInt("artist_id");
                String name = rs.getString("name");
                Seller s = new Seller(sellerId, name);
                return s;
            }else{
                return null;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }




    }


