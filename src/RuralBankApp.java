import java.util.*;
public class RuralBankApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Customer customer;

    public static void main(String[] args) {
        System.out.println("Welcome to Rural Bank of Nepal");
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        customer = new Customer(name);

        // Create two accounts for the customer
        BankAccount savings = new BankAccount(name) {
            @Override
            public void withdraw(double amount) throws InsufficientBalanceException {

            }

            @Override
            public String getAccountType() {
                return "";
            }

        };
        BankAccount current = new BankAccount(name) {
            @Override
            public void withdraw(double amount) throws InsufficientBalanceException {

            }

            @Override
            public String getAccountType() {
                return "";
            }
        };

        customer.addAccount(savings);
        customer.addAccount(current);

        mainMenu();
    }

    private static void mainMenu() {
        while (true) {
            System.out.println("\nChoose operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Add Interest (Savings Only)");
            System.out.println("4. View Accounts");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int op = getInt();

            switch (op) {
                case 1: performDeposit(); break;
                case 2: performWithdraw(); break;
                case 3: performAddInterest(); break;
                case 4: customer.displayAccounts(); break;
                case 5: System.out.println("Thank you for using RBAMS!"); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void performDeposit() {
        BankAccount acc = selectAccount();
        if (acc == null) return;
        System.out.print("Enter amount to deposit: ");
        double amt = getDouble();
        acc.deposit(amt);
        System.out.println("Deposit successful. New balance: " + acc.getBalance());
    }

    private static void performWithdraw() {
        BankAccount acc = selectAccount();
        if (acc == null) return;
        System.out.print("Enter amount to withdraw: ");
        double amt = getDouble();
        try {
            acc.withdraw(amt);
            System.out.println("Withdrawal successful. New balance: " + acc.getBalance());
        } catch (InsufficientBalanceException e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }
    }

    private static void performAddInterest() {
        SavingsAccount savings = null;
        for (BankAccount acc : customer.getAccounts()) {
            if (acc instanceof SavingsAccount) {
                savings = (SavingsAccount) acc;
                break;
            }
        }
        if (savings == null) {
            System.out.println("No Savings Account found!");
            return;
        }
        savings.addInterest();
        System.out.println("Interest added. New balance: " + savings.getClass());
    }

    private static BankAccount selectAccount() {
        List<BankAccount> accounts = customer.getAccounts();
        System.out.println("Select account:");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i+1) + ". " + accounts.get(i).getAccountType() +
                    " (Acc No: " + accounts.get(i).getAccountNumber() + ")");
        }
        System.out.print("Enter choice: ");
        int idx = getInt() - 1;
        if (idx < 0 || idx >= accounts.size()) {
            System.out.println("Invalid account selection.");
            return null;
        }
        return accounts.get(idx);
    }

    private static int getInt() {
        while (true) {
            try { return Integer.parseInt(scanner.nextLine()); }
            catch (NumberFormatException e) { System.out.print("Invalid input, enter number: "); }
        }
    }

    private static double getDouble() {
        while (true) {
            try { return Double.parseDouble(scanner.nextLine()); }
            catch (NumberFormatException e) { System.out.print("Invalid input, enter number: "); }
        }
    }
}

