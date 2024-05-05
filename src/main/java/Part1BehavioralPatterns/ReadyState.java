package Part1BehavioralPatterns;

public class ReadyState implements StateOfVendingMachine
{
    private int snackId;
    private float priceOfSnack;
    private float moneyInserted;
    public ReadyState(int snackId, float priceOfSnack, float moneyInserted)
    {
        this.snackId = snackId;
        this.priceOfSnack = priceOfSnack;
        this.moneyInserted = moneyInserted;
    }
    public String selectSnack(VendingMachine machine, int snackId)
    {
        Snack thisSnack = machine.getSnack(snackId);
        if (thisSnack.getQuantity() == 0)
        {
            return "That Item is Out of Stock!";
        }
        if (moneyInserted < thisSnack.getPrice())
        {
            // Go to insert state
            machine.setState(new InsertMoneyState(thisSnack.getPrice(), snackId, moneyInserted));
            return "Selection changed to: " + thisSnack.getName() + ". Insert: $" + priceMinusMoney(thisSnack.getPrice());
        }
        // Don't need to change state, but change values
        this.snackId = snackId;
        priceOfSnack = thisSnack.getPrice();
        return "Snack changed to: " + thisSnack.getName() + ". Ready to Dispense! Change: $" + moneyMinusPrice();
    }

    public String insertMoney(VendingMachine machine, float moneyInserted)
    {
        // User might want to buy multiple of this item
        this.moneyInserted += moneyInserted;
        return "Ready to Dispense. Change: $" + moneyMinusPrice();
    }

    public String dispenseSnack(VendingMachine machine)
    {
        // Send off to handler
        Snack thisSnack = machine.getSnack(snackId);
        moneyInserted = moneyMinusPrice();
        machine.getHandler().dispenseSnack(thisSnack);
        if (thisSnack.getQuantity() == 0)
        {
            machine.setState(new IdleState());
            return "Item now Out of Stock, Returning $" + moneyInserted;
        }
        if (priceOfSnack > moneyInserted)
        {
            // Return to insert money state
            machine.setState(new InsertMoneyState(priceOfSnack, snackId, moneyInserted));
            return "Remaining Change: $" + moneyInserted + ". Insert $" + priceMinusMoney() + " or cancel to get change.";
        }
        return "Remaining Change: $" + moneyInserted;
    }

    public String cancelSelection(VendingMachine machine)
    {
        machine.setState(new IdleState());
        return "Canceling Selection. Returning $" + moneyInserted;
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
