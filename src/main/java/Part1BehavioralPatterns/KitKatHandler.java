package Part1BehavioralPatterns;

public class KitKatHandler extends SnackDispenseHandler
{
    public KitKatHandler(SnackDispenseHandler next)
    {
        super(next);
    }

    public void dispenseSnack(Snack thisSnack)
    {
        if (thisSnack.getName().equalsIgnoreCase("KitKat"))
        {
            // Real machine will activate the motor to dispense item
            thisSnack.dispenseSnack();
            System.out.println("KitKat Dispensed");
        }
        else
        {
            super.dispenseSnack(thisSnack);
        }
    }
}
