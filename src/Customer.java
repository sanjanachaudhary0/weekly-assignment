import java.util.*;
public class Customer {
    private String name;
    private List<BankAccount> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount acc) {
        accounts.add(acc);
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void displayAccounts() {
        System.out.println("\nAccounts of " + name + ":");
        for (BankAccount acc : accounts) {
            System.out.println("[" + acc.getAccountType() + " Account] " +
                    "Account No: " + acc.getAccountNumber() +
                    ", Balance: " + acc.getBalance());
        }
    }
}
