////////////////////////////////////////////////////////////////////
// [VALTON] [TAHIRAJ] [1193389]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

public class TakeAwayBillImp implements TakeAwayBill {

    public double getOrderPrice(List<MenuItem> itemsOrdered, User user) 
            throws RestaurantBillException {
        
        
        if(itemsOrdered.size()>30) {
            throw new RestaurantBillException
            ("Non puoi ordinare più di 30 elementi.");
        }
        
        double totale=0;               
        int numGelati=0;
        for(int i = 0; i < itemsOrdered.size(); i++) {
            if(itemsOrdered.get(i).getItemType()==ItemType.Gelati) {
                numGelati++;
            }
        }
        double subtotal=0;
        double minimoGelato=Double.MAX_VALUE;
        for (int i = 0; i < itemsOrdered.size(); i++) {
                if(itemsOrdered.get(i).getItemType()==ItemType.Gelati) {
                    subtotal+=itemsOrdered.get(i).getPrice();
                    minimoGelato= itemsOrdered.get(i).getPrice()<minimoGelato 
                            ? itemsOrdered.get(i).getPrice() : minimoGelato;
                } else if(itemsOrdered.get(i).getItemType()==ItemType.Budini) {
                    subtotal+=itemsOrdered.get(i).getPrice();                 
                }
                
            totale+=itemsOrdered.get(i).getPrice();   
            
        }
        if(numGelati>5) {
            totale=totale-(minimoGelato/2);
        } 
        
        if(subtotal>50) {
            totale=totale-(totale*0.1);
        }
            
        return totale;
                
    }

}
