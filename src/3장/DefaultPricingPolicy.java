import java.math.BigDecimal;

public class DefaultPricingPolicy implements PricingPolicy {
    private static final int BASE_A = 100;
    private static final int BASE_OTHER = 150;
    private static final int SHIPPING_A = 500;
    private static final int SHIPPING_OTHER = 1200;
    private static final int WEIGHT_PER_UNIT = 2;
    private static final int EXTRA_WEIGHT_LIMIT = 10;
    private static final int EXTRA_COST = 800;

    @Override
    public BigDecimal calculateBasePrice(String itemId, int quantity) {
        int baseUnit = itemId.startsWith("A") ? BASE_A : BASE_OTHER;
        int shipping = itemId.startsWith("A") ? SHIPPING_A : SHIPPING_OTHER;
        int weight = WEIGHT_PER_UNIT * quantity;
        int extra = (weight > EXTRA_WEIGHT_LIMIT) ? EXTRA_COST : 0;

        return BigDecimal.valueOf(baseUnit)
                .multiply(BigDecimal.valueOf(quantity))
                .add(BigDecimal.valueOf(shipping))
                .add(BigDecimal.valueOf(extra));
    }
}
