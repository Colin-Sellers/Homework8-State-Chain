import Part1BehavioralPatterns.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class VendingMachineTest
{
    VendingMachine testMachine = new VendingMachine();


    @Test
    public void setAndGetStateTest()
    {
        StateOfVendingMachine expected = new InsertMoneyState(1.99F,0);
        testMachine.setState(expected);
        StateOfVendingMachine actual = testMachine.getState();
        assertEquals(expected, actual);
    }
    @Test
    public void getSnackTest()
    {
        Snack testSnack = testMachine.getSnack(0);
        String expected = "Coke";
        String actual = testSnack.getName();
        assertEquals(expected, actual);
    }

    // Select Snack, Insert Money, Dispense Snack, Cancel Selection
    // only display here, real tests are in individual state tests
}
