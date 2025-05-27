public abstract class BankAccount {
    private static int counter = 1001;
    private String accountHolderName;
    private String accountNumber;
    protected double balance;

    public BankAccount(String name) {
        this.accountHolderName = name;
        this.accountNumber = "RB" + (counter++);
        this.balance = 0.0;
    }

    public String getAccountHolderName() { return accountHolderName; }
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public abstract void withdraw(double amount) throws InsufficientBalanceException;

    public abstract String getAccountType();

}
