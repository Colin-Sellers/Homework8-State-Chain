import Part1BehavioralPatterns.StateOfVendingMachine;
import Part1BehavioralPatterns.VendingMachine;
import Part1BehavioralPatterns.InsertMoneyState;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class InsertMoneyTest
{
    VendingMachine testMachine = new VendingMachine();
    StateOfVendingMachine stateTest = new InsertMoneyState(1.99F, 0);
    @Test
    public void selectSnackTest()
    {
        String expected = "Snack changed to: Pepsi. Insert: $1.99";
        String actual = stateTest.selectSnack(testMachine, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void insertMoneyTest()
    {
        String expected = "Please insert $0.99";
        String actual = stateTest.insertMoney(testMachine, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void dispenseSnackTest()
    {
        String expected = "Please insert $1.99";
        String actual = stateTest.dispenseSnack(testMachine);
        assertEquals(expected, actual);
    }

    @Test
    public void cancelSelectionTest()
    {
        stateTest.insertMoney(testMachine, 1);
        String expected = "Snack Selection Canceled. Returning $1.0";
        String actual = stateTest.cancelSelection(testMachine);
        assertEquals(expected, actual);
    }
}