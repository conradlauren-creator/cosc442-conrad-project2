import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach; 

public class VendingMachineItemTest {
   
    VendingMachineItem myItem;

    @BeforeEach
    void setUp() {
        // ARRANGE
        myItem = new VendingMachineItem("Doritos", 1.25);
    }

    @AfterEach
    void tearDown() {
       myItem = null;
    }

   @Test
    void testValidVendingMachineItem() {
        //ASSERT
        assertEquals("Doritos", myItem.getName());
        assertEquals(1.25, myItem.getPrice(), 0.0001);
    }

    @Test
    void testNegativeItemPrice() {
        //ASSERT
         assertThrows(VendingMachineException.class,
        () -> new VendingMachineItem("Chicken", -1.25));
    }
   
    @Test
    void testGetName() {
        //ASSERT
        assertEquals("Doritos", myItem.getName());
    }

    @Test
    void testGetPrice() {
        //ASSERT
        assertEquals(1.25, myItem.getPrice());
    }
}
