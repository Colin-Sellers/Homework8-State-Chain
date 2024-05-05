package Part1BehavioralPatterns;

public class IdleState implements StateOfVendingMachine
{
    public String selectSnack(VendingMachine machine, int snackId)
    {
        Snack thisSnack = machine.getSnack(snackId);
        if (thisSnack.getQuantity() == 0)
        {
            return "That Item is Out of Stock!";
        }
        machine.setState(new InsertMoneyState(thisSnack.getPrice(), snackId));
        return thisSnack.getName() + " Selected. Please Insert $" + thisSnack.getPrice();
    }

    public String insertMoney(VendingMachine machine, float moneyInserted)
    {
        return "Please Select a Snack!";
    }

    public String dispenseSnack(VendingMachine machine)
    {
        return "Please Select a Snack!";
    }

    public String cancelSelection(VendingMachine machine)
    {
        return "Please Select a Snack!";
    }
}
