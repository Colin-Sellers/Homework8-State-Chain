import Part1BehavioralPatterns.Snack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class SnackTest
{
    Snack testSnack = new Snack("Coke", 1.99F, 10);

    @Test
    public void dispenseSnackAndGetQuantityTest()
    {
        testSnack.dispenseSnack();
        int expected = 9;
        int actual = testSnack.getQuantity();
        assertEquals(expected, actual);
    }

    @Test
    public void getNameTest()
    {
        String expected = "Coke";
        String actual = testSnack.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void getPriceTest()
    {
        float expected = 1.99F;
        float actual = testSnack.getPrice();
        assertEquals(expected, actual);
    }
}
