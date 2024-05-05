package Part1BehavioralPatterns;
import java.util.List;
import java.util.ArrayList;

public class VendingMachine
{
    private StateOfVendingMachine state = new IdleState();
    private final SnackDispenseHandler handler;
    private List<Snack> snackList = new ArrayList<>();

    public VendingMachine()
    {
        handler = new CokeHandler(new PepsiHandler(new CheetosHandler(new DoritosHandler(new KitKatHandler(new SnickersHandler(null))))));
        snackList.add(new Snack("Coke", 1.99F, 10));
        snackList.add(new Snack("Pepsi", 1.99F, 12));
        snackList.add(new Snack("Cheetos", 0.70F, 13));
        snackList.add(new Snack("Doritos", 0.90F, 8));
        snackList.add(new Snack("KitKat", 1.40F, 5));
        snackList.add(new Snack("Snickers", 1.30F, 2));
    }
    public void setState(StateOfVendingMachine state)
    {
        this.state = state;
    }
    public StateOfVendingMachine getState()
    {
        return state;
    }

    public Snack getSnack(int snackId)
    {
        return snackList.get(snackId);
    }
    public SnackDispenseHandler getHandler()
    {
        return handler;
    }

    // Different Actions the Vending Machine can do
    // Each action will change the State of the machine
    public void selectSnack(int snack)
    {
        // idle --> insert
        String outcome = getState().selectSnack(this, snack);
        System.out.println(outcome);
    }
    public void insertMoney(float moneyInserted)
    {
        // if money >= price, insert --> ready
        String outcome = getState().insertMoney(this, moneyInserted);
        System.out.println(outcome);
    }
    public void dispenseSnack()
    {
        // ready --> idle
        String outcome = getState().dispenseSnack(this);
        System.out.println(outcome);
    }
    public void cancelSelection()
    {
        // insert or ready --> idle
        String outcome = getState().cancelSelection(this);
        System.out.println(outcome);
    }
}
