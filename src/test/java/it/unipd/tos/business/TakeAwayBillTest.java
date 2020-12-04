////////////////////////////////////////////////////////////////////
// [VALTON] [TAHIRAJ] [1193389]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

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
        TakeAwayBillImp.charity=10;
        
        
    }
    
    @Test
    public void testGetOrderPriceStandard() {
        List<MenuItem> listino = new ArrayList<MenuItem>();
        listino.add(new MenuItem(ItemType.Gelati,"Pinguino",2));
        listino.add(new MenuItem(ItemType.Bevande,"CocaCola",3));
        listino.add(new MenuItem(ItemType.Budini,"BudinozzoVero",5)); 

        try {
            assertEquals(10, testino.getOrderPrice(listino, new User("1193389","Rintarou","Okabe",LocalDate.of(2000,1,1)),LocalTime.of(20, 30)),0);
        } catch (RestaurantBillException e) {
            // TODO Auto-generated catch block
            fail("Fallito");
            
        }
        
    }
    
    @Test
    public void testGetOrderPriceVuoto() {
        List<MenuItem> listinoVuotino = new ArrayList<MenuItem>();
        
        try {
            assertEquals(0, testino.getOrderPrice(listinoVuotino, new User("1193389","Rintarou","Okabe",LocalDate.of(2000,1,1)),LocalTime.of(20, 30)),0);
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
            assertEquals(29, testino.getOrderPrice(listinoCinque, new User("1193389","Rintarou","Okabe",LocalDate.of(2000,1,1)),LocalTime.of(20, 30)),0);
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
            assertEquals(25, testino.getOrderPrice(listinoCinque, new User("1193389","Rintarou","Okabe",LocalDate.of(2000,1,1)),LocalTime.of(20, 30)),0);
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
            assertEquals(229.5, testino.getOrderPrice(listinoCinque, new User("1193389","Rintarou","Okabe",LocalDate.of(2000,1,1)),LocalTime.of(15, 30)),0);
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
            assertEquals(85.5, testino.getOrderPrice(listinoCinque, new User("1193389","Rintarou","Okabe",LocalDate.of(2000,1,1)),LocalTime.of(20, 30)),0);
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
            assertEquals(9.5, testino.getOrderPrice(listino, new User("1193389","Rintarou","Okabe",LocalDate.of(2000,1,1)),LocalTime.of(18, 30)),0);
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
            assertEquals(10, testino.getOrderPrice(listino, new User("1193389","Rintarou","Okabe",LocalDate.of(2005,1,1)),LocalTime.of(20, 30)),0);
        } catch (RestaurantBillException e) {
            // TODO Auto-generated catch block
            fail("Fallito");
            
        }
        
    }
    
    @Test(expected = RestaurantBillException.class)
    public void testMoreThan30Orders() throws RestaurantBillException{
        List<MenuItem> list = new ArrayList<MenuItem>();
        for(int i = 0; i < 40; i++) {
            list.add(new MenuItem(ItemType.Gelati, "Gelatone", 1));
        }
        testino.getOrderPrice(list,new User("1193389","Rintarou","Okabe",LocalDate.of(2000,1,1)),LocalTime.of(20, 30));
    }
    
    
    @Test
    public void testGiveaway() {
        List<MenuItem> listino = new ArrayList<MenuItem>();
        listino.add(new MenuItem(ItemType.Gelati,"Pinguino",10));
        Random seed= new Random(500);
        double totale=0;
        
        for(int i=0;i<50;i++) {
            try {
                totale+= testino.getOrderPrice(listino,new User("1193389","Rintarou","Okabe",LocalDate.now()), LocalTime.of(18, 30));
            } catch (RestaurantBillException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        
        Vector<Integer> testino = new Vector<Integer>(100);
        
        
        
        
        for (int i=0;i<100;++i) {
            int x=seed.nextInt() & Integer.MAX_VALUE;
            testino.add(x%100);
        }
        
        double trueTotal=0;
        int charity=0;
        for (int i=0; i<50;++i) {
            
            if(testino.elementAt(i)<50 && charity<10) {     
                ++charity;
                trueTotal+=0;
            } else trueTotal+=10;
            
        }
        
        assertEquals(trueTotal,totale,0);
        
        
    }
    
    
    @Test
    public void testGiveawayLimiteMax() {
        List<MenuItem> listino = new ArrayList<MenuItem>();
        listino.add(new MenuItem(ItemType.Gelati,"Pinguino",10));
        double totale=0;
        
        for(int i=0;i<50;i++) {
            try {
                totale+= testino.getOrderPrice(listino,new User("1193389","Rintarou","Okabe",LocalDate.now()), LocalTime.of(19,00,01));
            } catch (RestaurantBillException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
            
        assertEquals(500,totale,0);
        
        
    }
    
    @Test
    public void testGiveawayLimiteMin() {
        List<MenuItem> listino = new ArrayList<MenuItem>();
        listino.add(new MenuItem(ItemType.Gelati,"Pinguino",10));       
        double totale=0;
        
        for(int i=0;i<50;i++) {
            try {
                totale+= testino.getOrderPrice(listino,new User("1193389","Rintarou","Okabe",LocalDate.now()), LocalTime.of(17,59,59));
            } catch (RestaurantBillException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
            
        assertEquals(500,totale,0);
        
        
    }
    
    @Test
    public void testGiveawayLimiteMinPiu() {
        List<MenuItem> listino = new ArrayList<MenuItem>();
        listino.add(new MenuItem(ItemType.Gelati,"Pinguino",10));       
        double totale=0;
        
        for(int i=0;i<50;i++) {
            try {
                totale+= testino.getOrderPrice(listino,new User("1193389","Rintarou","Okabe",LocalDate.now()), LocalTime.of(18,00,00));
            } catch (RestaurantBillException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
            
        assertEquals(400,totale,0);
        
        
    }
    
    @Test
    public void testGiveawayLimiteMaxMeno() {
        List<MenuItem> listino = new ArrayList<MenuItem>();
        listino.add(new MenuItem(ItemType.Gelati,"Pinguino",10));       
        double totale=0;
        
        for(int i=0;i<50;i++) {
            try {
                totale+= testino.getOrderPrice(listino,new User("1193389","Rintarou","Okabe",LocalDate.now()), LocalTime.of(19,00,00));
            } catch (RestaurantBillException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
            
        assertEquals(400,totale,0);
        
        
    }
    
    
   
    
    

    
    
    
}