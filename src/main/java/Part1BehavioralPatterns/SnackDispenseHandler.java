package Part1BehavioralPatterns;

public abstract class SnackDispenseHandler
{
    private SnackDispenseHandler next;

    public SnackDispenseHandler(SnackDispenseHandler next)
    {
        this.next = next;
    }

    public void dispenseSnack(Snack thisSnack)
    {
        if (next != null)
        {
            next.dispenseSnack(thisSnack);
        }
    }
}
