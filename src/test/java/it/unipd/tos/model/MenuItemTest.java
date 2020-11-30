////////////////////////////////////////////////////////////////////
// [VALTON] [TAHIRAJ] [1193389]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;




public class MenuItemTest {
    private MenuItem tester;
    
    @Before
    public void beforeTest() {
        tester= new MenuItem(ItemType.Bevande,"DrPepper",5);
        
    }
    
    @Test
    public void itemTypeTest() {
        assertEquals(ItemType.Bevande,tester.getItemType());
    }
    
    @Test
    public void nameTest() {
        assertEquals("DrPepper",tester.getName());
    }
    
    @Test
    public void priceTest() {
        assertEquals(5,tester.getPrice(),0);
    }
}
