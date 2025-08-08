package Lib.Discount;
import Lib.*;

/**
 * กลยุทธ์ส่วนลด Bulk (ซื้อเยอะลดราคา)
 */
public class BulkDiscountStrategy implements DiscountStrategy {
    private final int minimumQuantity;
    private final double discountPercentage;

    public BulkDiscountStrategy(int minimumQuantity, double discountPercentage) {
        this.minimumQuantity = minimumQuantity;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculatePrice(CartItem item) {
        double originalPrice = item.getProduct().getPrice() * item.getQuantity();
        if (item.getQuantity() >= minimumQuantity) {
            return originalPrice * (1.0 - discountPercentage);
        }
        return originalPrice;
    }
}
