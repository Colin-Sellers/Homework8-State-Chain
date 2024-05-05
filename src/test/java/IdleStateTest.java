import Part1BehavioralPatterns.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class IdleStateTest
{
    VendingMachine testMachine = new VendingMachine();
    StateOfVendingMachine stateTest = new IdleState();
    @Test
    public void selectSnackTest()
    {
        String expected = "Coke Selected. Please Insert $1.99";
        String actual = stateTest.selectSnack(testMachine, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void insertMoneyTest()
    {
        String expected = "Please Select a Snack!";
        String actual = stateTest.insertMoney(testMachine, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void dispenseSnackTest()
    {
        String expected = "Please Select a Snack!";
        String actual = stateTest.dispenseSnack(testMachine);
        assertEquals(expected, actual);
    }

    @Test
    public void cancelSelectionTest()
    {
        String expected = "Please Select a Snack!";
        String actual = stateTest.cancelSelection(testMachine);
        assertEquals(expected, actual);
    }
}
