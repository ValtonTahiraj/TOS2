package it.unipd.tos.business.exception;



import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RestaurantBillExceptionTest{
    
    
    @Test
    public void restaurantBillExcTest() {
        assertEquals("Fallito",new RestaurantBillException("Fallito").getMessage());
    }
}
