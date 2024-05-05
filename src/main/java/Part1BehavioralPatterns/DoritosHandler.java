package Part1BehavioralPatterns;

public class DoritosHandler extends SnackDispenseHandler
{
    public DoritosHandler(SnackDispenseHandler next)
    {
        super(next);
    }

    public void dispenseSnack(Snack thisSnack)
    {
        if (thisSnack.getName().equalsIgnoreCase("Doritos"))
        {
            // Real machine will activate the motor to dispense item
            thisSnack.dispenseSnack();
            System.out.println("Doritos Dispensed");
        }
        else
        {
            super.dispenseSnack(thisSnack);
        }
    }
}
