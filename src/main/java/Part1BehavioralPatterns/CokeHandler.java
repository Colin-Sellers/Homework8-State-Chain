package Part1BehavioralPatterns;

public class CokeHandler extends SnackDispenseHandler
{

    public CokeHandler(SnackDispenseHandler next)
    {
        super(next);
    }

    public void dispenseSnack(Snack thisSnack)
    {
        if (thisSnack.getName().equalsIgnoreCase("Coke"))
        {
            // Real machine will activate the motor to dispense item
            thisSnack.dispenseSnack();
            System.out.println("Coke Dispensed");
        }
        else
        {
            super.dispenseSnack(thisSnack);
        }
    }
}
