import java.math.BigDecimal;

public class Receipt {
    private final String orderId;
    private final String userId;
    private final String itemId;
    private final int quantity;
    private final BigDecimal totalAmount;

    public Receipt(String orderId, String userId, String itemId, int quantity, BigDecimal totalAmount) {
        this.orderId = orderId;
        this.userId = userId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }

    public String getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return String.format("Receipt{orderId='%s', userId='%s', itemId='%s', qty=%d, total=%s}",
                orderId, userId, itemId, quantity, totalAmount);
    }
}
