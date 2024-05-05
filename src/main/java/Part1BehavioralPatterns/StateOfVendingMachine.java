package Part1BehavioralPatterns;

public interface StateOfVendingMachine
{
    String selectSnack(VendingMachine machine, int snackId);
    String insertMoney(VendingMachine machine, float moneyInserted);
    String dispenseSnack(VendingMachine machine);
    String cancelSelection(VendingMachine machine);
}
