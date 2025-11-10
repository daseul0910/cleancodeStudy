import java.math.BigDecimal;
import java.util.UUID;

public class MockOrderRepository {
    public String save(String userId, String itemId, int qty, BigDecimal total) {
        String orderId = UUID.randomUUID().toString();
        System.out.println(
                "SAVE: order=" + orderId + " user=" + userId + " item=" + itemId + " qty=" + qty + " sum=" + total);
        return orderId;
    }
}
