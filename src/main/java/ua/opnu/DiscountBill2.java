import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

public final class DiscountBill2 {
    private GroceryBill bill;
    /** Ознака, чи є клієнт постійним. */
    private final boolean regularCustomer;
    /** Кількість знижок у чеку. */
    private int discountCount = 0;
    /** Загальна сума знижок. */
    private double discountAmount = 0.0;
    /** Повна ціна без знижок. */
    private double totalPriceWithoutDiscount = 0.0;
    private static final double PERCENT_MULTIPLIER = 100.0;

    public DiscountBill2(final Employee clerk, final boolean regularCustomer) {
        this.bill = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
    }

    public Employee getClerk() {
        return bill.getClerk();
    }

    public void add(final Item i) {
        bill.add(i);
        if (regularCustomer && i.getDiscount() > 0.0) {
            discountCount++;
            discountAmount += i.getDiscount();
        }
        totalPriceWithoutDiscount += i.getPrice();
    }

    public double getTotal() {
        double total = bill.getTotal();
        if (regularCustomer) {
            return total - discountAmount;
        }
        return total;
    }

    public int getDiscountCount() {
        if (regularCustomer) {
            return discountCount;
        }
        return 0;
    }

    public double getDiscountAmount() {
        if (regularCustomer) {
            return discountAmount;
        }
        return 0;
    }

    public double getDiscountPercent() {
        if (!regularCustomer || totalPriceWithoutDiscount == 0.0) {
            return 0.0;
        }
        return (discountAmount * PERCENT_MULTIPLIER)
                / totalPriceWithoutDiscount;
    }
}
