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
        assertDoesNotThrow(() -> new VendingMachine());
    }

    @Test
    void testAddItem() {
        myVending.addItem(myItem,"B");
        assertEquals(myItem, myVending.getItem("B"));
        myVending.removeItem("B");
    }

    @Test 
    void testAddAlreadyFullItem() {
    assertThrows(
		    VendingMachineException.class, 
        () -> myVending.addItem(myItem, "A"));
    }

    @Test
    void testAddItemWithInvalidCode() {
        assertThrows(
		    VendingMachineException.class, 
        () -> myVending.addItem(myItem, "F"));
    }

    @Test
    void testGetBalance() {
        assertEquals(10, myVending.getBalance(), 0.01);
    }


    @Test
    void testGetItem() {
        assertEquals(myItem, myVending.getItem("A"));
        assertEquals(null, myVending.getItem("D"));
    }


    @Test
    void testInsertMoney() {
        myVending.insertMoney(5);
        assertEquals(15, myVending.balance, 0.01);
    }

    @Test
    void testInsertZeroMoney() {
        assertThrows(
		    VendingMachineException.class, 
        () -> myVending.insertMoney(-1));
    }


    @Test
    void testMakePurchase() {
        assertTrue(myVending.makePurchase("A"));
    }

    @Test
    void testMakeNegativePurchase() {
        myVending.balance = 1;
        assertFalse(myVending.makePurchase("A"));
    }

    @Test
    void testMakePurchaseWithWrongCode() {
         assertThrows(
		    VendingMachineException.class, 
        () -> myVending.makePurchase("F"));
    }



    @Test
    void testRemoveItem() {
        assertEquals(myItem, myVending.removeItem("A"));
    }

    @Test 
    void testRemoveAlreadyEmptyItem() {
    assertThrows(
		    VendingMachineException.class, 
        () -> myVending.removeItem("B"));
    }


    @Test
    void testReturnChange() {
        assertEquals(10, myVending.returnChange(), 0.01);
        assertEquals(0, myVending.balance, 0.01);
    }

    @Test
    void testReturnZeroChange() {
        myVending.balance = 0;
        assertEquals(0, myVending.returnChange(), 0.01);
        assertEquals(0, myVending.balance, 0.01);
    }

    @Test
    void testReturnNegativeChange() {
        myVending.balance = 0;
        assertThrows(
		    VendingMachineException.class, 
        () -> myVending.returnChange());
    }


}
