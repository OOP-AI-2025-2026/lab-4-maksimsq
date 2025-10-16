import ua.opnu.java.inheritance.account.BankingAccount;
import ua.opnu.java.inheritance.account.Credit;
import ua.opnu.java.inheritance.account.Debit;
import ua.opnu.java.inheritance.account.Startup;

public final class MinMaxAccount extends BankingAccount {
    /** Мінімальний баланс рахунку. */
    private int min;
    /** Максимальний баланс рахунку. */
    private int max;

    public MinMaxAccount(final Startup s) {
        super(s);
        int initialBalance = getBalance();
        min = initialBalance;
        max = initialBalance;
    }

    @Override
    public void debit(final Debit d) {
        super.debit(d);
        updateMinMax();
    }

    @Override
    public void credit(final Credit c) {
        super.credit(c);
        updateMinMax();
    }

    private void updateMinMax() {
        int currentBalance = getBalance();
        if (currentBalance < min) {
            min = currentBalance;
        }
        if (currentBalance > max) {
            max = currentBalance;
        }
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
