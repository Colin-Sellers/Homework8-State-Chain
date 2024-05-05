package Part1BehavioralPatterns;

public class CheetosHandler extends SnackDispenseHandler
{
    public CheetosHandler(SnackDispenseHandler next)
    {
        super(next);
    }

    public void dispenseSnack(Snack thisSnack)
    {
        if (thisSnack.getName().equalsIgnoreCase("Cheetos"))
        {
            // Real machine will activate the motor to dispense item
            thisSnack.dispenseSnack();
            System.out.println("Cheetos Dispensed");
        }
        else
        {
            super.dispenseSnack(thisSnack);
        }
    }
}
