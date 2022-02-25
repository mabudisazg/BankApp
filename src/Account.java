import java.util.Scanner;

public class Account {
    //Varijable
    private int balance;
    private int previousTransaction;
    private String customerName;
    private String customerID;

    //Constructor
    public Account(String customerName, String customerID){
        this.customerName = customerName;
        this.customerID = customerID;
    }

    //Function for depositing money
    public void deposit(int amount){
        if(amount != 0){
            balance += amount;
            previousTransaction = amount;
        }
    }

    //Function for withdrawing money
    public void withdraw(int amount){
        if(amount != 0){
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    //Function for showing previous transaction
    public void getPreviousTransaction(){
        if(previousTransaction > 0) System.out.println("Deposited: " + previousTransaction);
        else if(previousTransaction < 0) System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        else System.out.println("No transactions occurred");
    }

    //Function for calculating interest of current funds after number of years
    public void calculateInterest(int years){
        double interestRate = .02;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is: " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years, your new balance will be: " + newBalance);
    }

    //Menu
    public void showMenu(){
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("A: Check your balance.");
        System.out.println("B: Make a deposit.");
        System.out.println("C: Make a withdrawal.");
        System.out.println("D: View previous transaction.");
        System.out.println("E: Calculate interest.");
        System.out.println("F: Exit.");

        do{
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch(option){
                case 'A':
                    System.out.println("========================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("========================");
                    System.out.println();
                    break;
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amountToDeposit = scanner.nextInt();
                    deposit(amountToDeposit);
                    System.out.println();
                    break;
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amountToWithdraw = scanner.nextInt();
                    withdraw(amountToWithdraw);
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("========================");
                    getPreviousTransaction();
                    System.out.println("========================");
                    System.out.println();
                    break;
                case 'E':
                    System.out.println("Enter how many years of interest: ");
                    int yearsOfInterest = scanner.nextInt();
                    calculateInterest(yearsOfInterest);
                    break;
                case'F':
                    System.out.println("========================");
                    break;
                default:
                    System.out.println("Error! Invalid option. Please enter one of the above options.");
                    break;
            }
        } while(option != 'F');
        System.out.println("Thank you for banking with us!");

    }
}
