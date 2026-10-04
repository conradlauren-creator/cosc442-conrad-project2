import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class VendingMachineExceptionTest {
    
    VendingMachineException myVendingException;

    @Test
    void testEmptyVendingMachineException() {
        //ARRANGE
        myVendingException = new VendingMachineException();
        //ASSERT
        assertEquals(null, myVendingException.getMessage());
    }

    @Test
    void testVendingMachineException(){
        //ARRANGE
        myVendingException = new VendingMachineException("Reason");
        //ASSERT
        assertEquals("Reason", myVendingException.getMessage());

    }
}
