////////////////////////////////////////////////////////////////////
// [VALTON] [TAHIRAJ] [1193389]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;




public class UserTest {
    private User tester;
    
    @Before
    public void beforeTest() {
        tester= new User("1193389","Valton","Tahiraj",LocalDate.of(2000, 1, 16));
        
    }
    
    @Test
    public void idTest() {
        assertEquals("1193389",tester.getId());
    }
    
    @Test
    public void nameTest() {
        assertEquals("Valton",tester.getNome());
    }
    
    @Test
    public void cognomeTest() {
        assertEquals("Tahiraj",tester.getCognome());
    }
    
    @Test
    public void dateTest() {
        assertEquals(LocalDate.of(2000, 1, 16),tester.getNascita());
    }
}