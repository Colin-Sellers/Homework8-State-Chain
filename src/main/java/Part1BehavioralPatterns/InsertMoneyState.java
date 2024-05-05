package Part1BehavioralPatterns;

public class InsertMoneyState implements StateOfVendingMachine
{
    private int snackId;
    private float priceOfSnack;
    private float moneyInserted = 0.00F;

    public InsertMoneyState(float priceOfSnack, int snackId)
    {
        this.priceOfSnack = priceOfSnack;
        // Saved to pass onto dispense when ready
        this.snackId = snackId;
    }
    public InsertMoneyState(float priceOfSnack, int snackId, float existingMoney)
    {
        this.priceOfSnack = priceOfSnack;
        this.snackId = snackId;
        moneyInserted = existingMoney;
    }

    public String selectSnack(VendingMachine machine, int snackId)
    {
        Snack thisSnack = machine.getSnack(snackId);
        if (thisSnack.getQuantity() == 0)
        {
            return "That Item is Out of Stock!";
        }
        if (moneyInserted >= thisSnack.getPrice())
        {
            // Go to ready state
            machine.setState(new ReadyState(snackId, thisSnack.getPrice(), moneyInserted));
            return "Selection changed to: " + thisSnack.getName() + ", Ready to Dispense! Extra Change: $" + priceMinusMoney(thisSnack.getPrice());
        }
        // Don't need to change state, but change values
        this.snackId = snackId;
        priceOfSnack = thisSnack.getPrice();
        return "Snack changed to: " + thisSnack.getName() + ". Insert: $" + priceMinusMoney();
    }

    public String insertMoney(VendingMachine machine, float moneyInserted)
    {
        this.moneyInserted += moneyInserted;
        if (this.moneyInserted < priceOfSnack)
        {
            return "Please insert $" + priceMinusMoney();
        }
        // Can buy at least 1 item, change to ready state
        // Pass info from this state to ready in case user wants to buy
        // multiple of the same item
        machine.setState(new ReadyState(snackId, priceOfSnack, this.moneyInserted));
        return "Ready to Dispense. Change: $" + moneyMinusPrice();
    }

    public String dispenseSnack(VendingMachine machine)
    {
        return "Please insert $" + priceMinusMoney();
    }

    public String cancelSelection(VendingMachine machine)
    {
        machine.setState(new IdleState());
        return "Snack Selection Canceled. Returning $" + moneyInserted;
    }

    // float operations may cause rounding errors, round to the cent
    public float priceMinusMoney()
    {
        return (float) Math.round((priceOfSnack - moneyInserted) * 100) / 100;
    }
    public float priceMinusMoney(float newPrice)
    {
        return (float) Math.round((newPrice - moneyInserted) * 100) / 100;
    }
    public float moneyMinusPrice()
    {
        return (float) Math.round((moneyInserted - priceOfSnack) * 100) / 100;
    }
}
