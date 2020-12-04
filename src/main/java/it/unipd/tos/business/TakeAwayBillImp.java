////////////////////////////////////////////////////////////////////
// [VALTON] [TAHIRAJ] [1193389]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;



import java.time.LocalTime;
import java.util.List;
import java.util.Random;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

public class TakeAwayBillImp implements TakeAwayBill {
    
    static int charity=10;
    static Random seed= new Random(500);
    

    public double getOrderPrice(List<MenuItem> itemsOrdered, User user, 
            LocalTime orderPrice) 
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
        
       
        if (giveaway(orderPrice, user)) {
            return 0;
        }
            
        return calcoloTotale(numGelati,minimoGelato,subtotal,totale);
                
    }
    
    private double calcoloTotale(double numGelati,double minimoGelato,
            double subtotal,double totale) {
        if(numGelati>5) {
            totale=totale-(minimoGelato/2);
        } 
        
        if(subtotal>50) {
            totale=totale-(totale*0.1);
        }
        
        if(totale!=0){
            if(totale<10){          
            totale+=0.5;
            }
        }
        
        return totale;
    }
    
    
    private boolean giveaway(LocalTime orderPrice, User user) {

        if (orderPrice.isAfter(LocalTime.of(17, 59, 59)) && 
                orderPrice.isBefore(LocalTime.of(19, 00, 01))) {
            if (user.isUnderAge()) {
                if (charity > 0) {

                    int x = seed.nextInt() & Integer.MAX_VALUE;
                    

                    if (x % 100 < 50) {
                        --charity;
                        return true;
                    }
                }
            }
        } else {
            charity = 10;
        }

        return false;

    }
    

}
