import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

public final class DiscountBill extends GroceryBill {
    /** Ознака, чи є клієнт постійним. */
    private final boolean regularCustomer;
    /** Кількість знижок у чеку. */
    private int discountCount = 0;
    /** Загальна сума знижок. */
    private double discountAmount = 0.0;
    /** Повна ціна без знижок. */
    private double totalPriceWithoutDiscount = 0.0;
    private static final double PERCENT_MULTIPLIER = 100.0;

    public DiscountBill(final Employee clerk, final boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
    }

    @Override
    public void add(final Item i) {
        super.add(i);
        if (regularCustomer) {
            if (i.getDiscount() > 0.0) {
                discountCount++;
                discountAmount += i.getDiscount();
            }
        }
        totalPriceWithoutDiscount += i.getPrice();
    }

    @Override
    public double getTotal() {
        double total = super.getTotal();
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
