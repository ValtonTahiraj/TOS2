////////////////////////////////////////////////////////////////////
// [VALTON] [TAHIRAJ] [1193389]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

public class TakeAwayBillImp implements TakeAwayBill {

    public double getOrderPrice(List<MenuItem> itemsOrdered, User user) 
            throws RestaurantBillException {
        
        double totale=0;
        
        for (int i = 0; i < itemsOrdered.size(); i++) {
            totale+=itemsOrdered.get(i).getPrice();
            
        }
        return totale;
    }

}
