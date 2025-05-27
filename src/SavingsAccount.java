public class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.05; // 5% per period

    public SavingsAccount(String name) {
        super(name);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) throw new InsufficientBalanceException("Withdraw amount must be positive.");
        if (amount > balance) throw new InsufficientBalanceException("Insufficient balance!");
        balance -= amount;
    }

    public void addInterest() {
        balance += balance * INTEREST_RATE;
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }

}
