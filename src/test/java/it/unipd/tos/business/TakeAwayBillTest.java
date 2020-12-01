////////////////////////////////////////////////////////////////////
// [VALTON] [TAHIRAJ] [1193389]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

public class TakeAwayBillTest {
    
    private TakeAwayBillImp testino;
    
    
    @Before  
    public void BeforeClass() {
        testino = new TakeAwayBillImp();
    }
    
    @Test
    public void testGetOrderPriceStandard() {
        List<MenuItem> listino = new ArrayList<MenuItem>();
        listino.add(new MenuItem(ItemType.Gelati,"Pinguino",2));
        listino.add(new MenuItem(ItemType.Bevande,"CocaCola",3));
        listino.add(new MenuItem(ItemType.Budini,"BudinozzoVero",5)); 

        try {
            assertEquals(10, testino.getOrderPrice(listino, new User("1193389","Rintarou","Okabe",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            // TODO Auto-generated catch block
            fail("Fallito");
            
        }
        
    }
    
    @Test
    public void testGetOrderPriceVuoto() {
        List<MenuItem> listinoVuotino = new ArrayList<MenuItem>();
        
        try {
            assertEquals(0, testino.getOrderPrice(listinoVuotino, new User("1193389","Rintarou","Okabe",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            // TODO Auto-generated catch block
            fail("Fallito");
            
        }
        
    } 
    
    @Test
    public void testCinqueGelati() {
        List<MenuItem> listinoCinque = new ArrayList<MenuItem>();
        listinoCinque.add(new MenuItem(ItemType.Gelati,"Pinguino",2));
        listinoCinque.add(new MenuItem(ItemType.Gelati,"CocaCola",3));
        listinoCinque.add(new MenuItem(ItemType.Gelati,"BudinozzoVero",5)); 
        listinoCinque.add(new MenuItem(ItemType.Gelati,"BudinozzoFalso",5)); 
        listinoCinque.add(new MenuItem(ItemType.Gelati,"BudinozzoSimpatico",5));
        listinoCinque.add(new MenuItem(ItemType.Gelati,"BudinozzoLezzino",5));
        listinoCinque.add(new MenuItem(ItemType.Budini,"BudinozzoNonSimpatico",5));
        
        try {
            assertEquals(29, testino.getOrderPrice(listinoCinque, new User("1193389","Rintarou","Okabe",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            // TODO Auto-generated catch block
            fail("Fallito");
            
        }
        
        
    }
    
    @Test
    public void testSeiGelati() {
        List<MenuItem> listinoCinque = new ArrayList<MenuItem>();
        listinoCinque.add(new MenuItem(ItemType.Gelati,"Pinguino",2));
        listinoCinque.add(new MenuItem(ItemType.Gelati,"CocaCola",3));
        listinoCinque.add(new MenuItem(ItemType.Gelati,"BudinozzoVero",5)); 
        listinoCinque.add(new MenuItem(ItemType.Gelati,"BudinozzoFalso",5)); 
        listinoCinque.add(new MenuItem(ItemType.Gelati,"BudinozzoSimpatico",5));       
        listinoCinque.add(new MenuItem(ItemType.Budini,"BudinozzoNonSimpatico",5));
        
        try {
            assertEquals(25, testino.getOrderPrice(listinoCinque, new User("1193389","Rintarou","Okabe",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            // TODO Auto-generated catch block
            fail("Fallito");
            
        }
        
        
    }
    
    @Test
    public void testSubtotaleScontoConScontoGelati() {
        List<MenuItem> listinoCinque = new ArrayList<MenuItem>();
        listinoCinque.add(new MenuItem(ItemType.Gelati,"Pinguino",20));
        listinoCinque.add(new MenuItem(ItemType.Gelati,"CocaCola",25));
        listinoCinque.add(new MenuItem(ItemType.Gelati,"BudinozzoVero",40)); 
        listinoCinque.add(new MenuItem(ItemType.Gelati,"BudinozzoFalso",30)); 
        listinoCinque.add(new MenuItem(ItemType.Gelati,"BudinozzoSimpatico",50));   
        listinoCinque.add(new MenuItem(ItemType.Gelati,"BudinozzoSimpatico",50));
        listinoCinque.add(new MenuItem(ItemType.Budini,"BudinozzoNonSimpatico",50));
        
        try {
            assertEquals(229.5, testino.getOrderPrice(listinoCinque, new User("1193389","Rintarou","Okabe",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            // TODO Auto-generated catch block
            fail("Fallito");
            
        }
        
        
    }
    
    @Test
    public void testSubtotaleScontoSenzaScontoGelati() {
        List<MenuItem> listinoCinque = new ArrayList<MenuItem>();
        listinoCinque.add(new MenuItem(ItemType.Gelati,"Pinguino",20));
        listinoCinque.add(new MenuItem(ItemType.Gelati,"CocaCola",25));
        listinoCinque.add(new MenuItem(ItemType.Budini,"BudinozzoNonSimpatico",50));
        
        try {
            assertEquals(85.5, testino.getOrderPrice(listinoCinque, new User("1193389","Rintarou","Okabe",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            // TODO Auto-generated catch block
            fail("Fallito");
            
        }
        
        
    }
    
    @Test
    public void testGetOrderPricePenale() {
        List<MenuItem> listino = new ArrayList<MenuItem>();
        listino.add(new MenuItem(ItemType.Gelati,"Pinguino",2));
        listino.add(new MenuItem(ItemType.Bevande,"CocaCola",2));
        listino.add(new MenuItem(ItemType.Budini,"BudinozzoVero",5)); 

        try {
            assertEquals(9.5, testino.getOrderPrice(listino, new User("1193389","Rintarou","Okabe",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            // TODO Auto-generated catch block
            fail("Fallito");
            
        }
        
    }
    
    @Test
    public void testGetOrderPricePenaleConSeiGelati() {
        List<MenuItem> listino = new ArrayList<MenuItem>();
        listino.add(new MenuItem(ItemType.Gelati,"Pinguino",1));
        listino.add(new MenuItem(ItemType.Gelati,"Pinguino",2));
        listino.add(new MenuItem(ItemType.Gelati,"Pinguino",2));
        listino.add(new MenuItem(ItemType.Gelati,"Pinguino",2));
        listino.add(new MenuItem(ItemType.Gelati,"Pinguino",2));
        listino.add(new MenuItem(ItemType.Gelati,"Pinguino",1));

        try {
            assertEquals(10, testino.getOrderPrice(listino, new User("1193389","Rintarou","Okabe",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            // TODO Auto-generated catch block
            fail("Fallito");
            
        }
        
    }
    
    
    
    
}