import Part1BehavioralPatterns.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class DispenseHandlerTest
{
    SnackDispenseHandler handlerTest = new CokeHandler(new PepsiHandler(new DoritosHandler(null)));
    Snack testSnack = new Snack("Pepsi", 1.99F, 10);

    @Test
    public void testDispenseHandler()
    {
        handlerTest.dispenseSnack(testSnack);
        int expected = 9;
        int actual = testSnack.getQuantity();
        assertEquals(expected, actual);
    }
}
