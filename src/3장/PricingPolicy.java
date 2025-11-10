import java.math.BigDecimal;

public interface PricingPolicy {
    BigDecimal calculateBasePrice(String itemId, int quantity);
}
