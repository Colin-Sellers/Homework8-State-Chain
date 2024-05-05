import Part1BehavioralPatterns.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class ReadyTest
{
    VendingMachine testMachine = new VendingMachine();
    StateOfVendingMachine stateTest = new ReadyState(0, 1.99F, 2.00F);
    @Test
    public void selectSnackTest()
    {
        String expected = "Snack changed to: Pepsi. Ready to Dispense! Change: $0.01";
        String actual = stateTest.selectSnack(testMachine, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void insertMoneyTest()
    {
        String expected = "Ready to Dispense. Change: $1.01";
        String actual = stateTest.insertMoney(testMachine, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void dispenseSnackTest()
    {
        String expected = "Remaining Change: $0.01. Insert $1.98 or cancel to get change.";
        String actual = stateTest.dispenseSnack(testMachine);
        assertEquals(expected, actual);
    }

    @Test
    public void cancelSelectionTest()
    {
        stateTest.insertMoney(testMachine, 1);
        String expected = "Canceling Selection. Returning $3.0";
        String actual = stateTest.cancelSelection(testMachine);
        assertEquals(expected, actual);
    }
}
