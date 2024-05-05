package Part1BehavioralPatterns;

public class PepsiHandler extends SnackDispenseHandler
{
    public PepsiHandler(SnackDispenseHandler next)
    {
        super(next);
    }

    public void dispenseSnack(Snack thisSnack)
    {
        if (thisSnack.getName().equalsIgnoreCase("Pepsi"))
        {
            // Real machine will activate the motor to dispense item
            thisSnack.dispenseSnack();
            System.out.println("Pepsi Dispensed");
        }
        else
        {
            super.dispenseSnack(thisSnack);
        }
    }
}
