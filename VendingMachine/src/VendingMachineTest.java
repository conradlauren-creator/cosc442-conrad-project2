import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*; 


public class VendingMachineTest {

    //in class, declare first so it's global
    VendingMachine myVending;
    VendingMachineItem myItem;

    @BeforeEach
    void setUp() {
        // ARRANGE
        myVending = new VendingMachine();
        myItem = new VendingMachineItem("Chips", 1.25);
        myVending.addItem(myItem, "A"); //adds an item to A
        myVending.balance = 10;
    }

    @AfterEach
    void tearDown() {
       myItem = null;
       myVending = null;
       myVending.balance = 0;
    }
    

       @Test
    void vendingMachineMethod() {
        //ASSERT
        assertDoesNotThrow(() -> new VendingMachine());
    }

    @Test
    void testAddItem() {
        //ACT
        myVending.addItem(myItem,"B");
        //ASSERT
        assertEquals(myItem, myVending.getItem("B"));
        myVending.removeItem("B");
    }

    @Test 
    void testAddAlreadyFullItem() {
        //ASSERT
        assertThrows(
		    VendingMachineException.class, 
        () -> myVending.addItem(myItem, "A"));
    }

    @Test
    void testAddItemWithInvalidCode() {
        //ASSERT
        assertThrows(
		    VendingMachineException.class, 
        () -> myVending.addItem(myItem, "F"));
    }

    @Test
    void testGetBalance() {
       //ASSERT 
        assertEquals(10, myVending.getBalance(), 0.01);
    }


    @Test
    void testGetItem() {
        //ASSERT
        assertEquals(myItem, myVending.getItem("A"));
        assertEquals(null, myVending.getItem("D"));
    }


    @Test
    void testInsertMoney() {
        //ACT
        myVending.insertMoney(5);
        //ASSERT
        assertEquals(15, myVending.balance, 0.01);
    }

    @Test
    void testInsertZeroMoney() {
        //ASSERT
        assertThrows(
		    VendingMachineException.class, 
        () -> myVending.insertMoney(-1));
    }


    @Test
    void testMakePurchase() {
        //ASSERT
        assertTrue(myVending.makePurchase("A"));
    }

    @Test
    void testMakeNegativePurchase() {
        //ACT
        myVending.balance = 1;
        //ASSERT
        assertFalse(myVending.makePurchase("A"));
    }

    @Test
    void testMakePurchaseWithWrongCode() {
        //ASSERT
         assertThrows(
		    VendingMachineException.class, 
        () -> myVending.makePurchase("F"));
    }



    @Test
    void testRemoveItem() {
        //ASSERT
        assertEquals(myItem, myVending.removeItem("A"));
    }

    @Test 
    void testRemoveAlreadyEmptyItem() {
        //ASSERT
        assertThrows(
                VendingMachineException.class, 
            () -> myVending.removeItem("B"));
    }


    @Test
    void testReturnChange() {
        //ASSERT
        assertEquals(10, myVending.returnChange(), 0.01);
        assertEquals(0, myVending.balance, 0.01);
    }

    @Test
    void testReturnZeroChange() {
        //ACT
        myVending.balance = 0;
        //ASSERT
        assertEquals(0, myVending.returnChange(), 0.01);
        assertEquals(0, myVending.balance, 0.01);
    }

    @Test
    void testReturnNegativeChange() {
        //ACT
        myVending.balance = 0;
        //ASSERT
        assertThrows(
		    VendingMachineException.class, 
        () -> myVending.returnChange());
    }


}
