public class CurrentAccount {
    private static final double OVERDRAFT_LIMIT = 5000.0;
    private double balance;

    public CurrentAccount(String name) {
        super();
    }


    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) throw new InsufficientBalanceException("Withdraw amount must be positive.");
        if (amount > balance + OVERDRAFT_LIMIT)
            throw new InsufficientBalanceException("Overdraft limit exceeded!");
        balance -= amount;
    }

    public String getAccountType() {
        return "Current";
    }
}

