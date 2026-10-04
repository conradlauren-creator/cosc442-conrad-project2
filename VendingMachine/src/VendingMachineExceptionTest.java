import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class VendingMachineExceptionTest {
    
    VendingMachineException myVendingException;

    @Test
    void testEmptyVendingMachineException() {
        myVendingException = new VendingMachineException();
        assertEquals(null, myVendingException.getMessage());
    }

    @Test
    void testVendingMachineException(){
        myVendingException = new VendingMachineException("Reason");
        assertEquals("Reason", myVendingException.getMessage());

    }
}
