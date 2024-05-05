package Part1BehavioralPatterns;

public class SnickersHandler extends SnackDispenseHandler
{
    public SnickersHandler(SnackDispenseHandler next)
    {
        super(next);
    }

    public void dispenseSnack(Snack thisSnack)
    {
        if (thisSnack.getName().equalsIgnoreCase("Snickers"))
        {
            // Real machine will activate the motor to dispense item
            thisSnack.dispenseSnack();
            System.out.println("Snickers Dispensed");
        }
        else
        {
            super.dispenseSnack(thisSnack);
        }
    }
}
