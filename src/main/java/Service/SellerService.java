package Service;

import DAO.SellerDAO;
import Model.Seller;
import Exceptions.SellerNotFoundException;

import java.util.List;

public class SellerService {
        SellerDAO sellerDAO;

        public SellerService(SellerDAO sellerDAO){
         this.sellerDAO = sellerDAO;
        }

        public List<Seller> getAllSeller(){
            return null;
        }

        public void saveSeller(Seller s){
            sellerDAO.insertSeller(s);

        }
    public Seller getSellerById(int id) throws SellerNotFoundException {
        Seller s = sellerDAO.getSellerById(id);
        if(s == null){
            throw new SellerNotFoundException("no seller with such id found");
        }else{
            return s;
        }
    }






}
