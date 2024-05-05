package Part1BehavioralPatterns;
import java.util.Scanner;

public class VendingMachineDriver
{
    public static void main(String args[])
    {
        VendingMachine vender = new VendingMachine();
        Scanner kb = new Scanner(System.in);
        int selection = 0;

        while (true)
        {
            System.out.println("\n(1): Select Snack");
            System.out.println("(2): Insert Money");
            System.out.println("(3): Dispense Item");
            System.out.println("(4): Cancel Selection");
            System.out.println("(5): Quit Simulation\n");

            selection = kb.nextInt();
            switch (selection)
            {
                case 1:
                    // Real life these are fixed buttons, cannot insert
                    // 10000000 or other random integers
                    System.out.println("\n(0): Coke");
                    System.out.println("(1): Pepsi");
                    System.out.println("(2): Cheetos");
                    System.out.println("(3): Doritos");
                    System.out.println("(4): KitKat");
                    System.out.println("(5): Snickers\n");
                    selection = kb.nextInt();
                    vender.selectSnack(selection % 6);
                    break;

                case 2:
                    System.out.print("Insert: ");
                    float amount = kb.nextFloat();
                    vender.insertMoney(amount);
                    break;

                case 3:
                    vender.dispenseSnack();
                    break;

                case 4:
                    vender.cancelSelection();
                    break;

                case 5:
                    System.exit(0);
                    break;

                default:
                    // Do nothing
                    break;
            }
        }
    }
}
