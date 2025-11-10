import java.math.BigDecimal;

public class CombinedDiscountPolicy implements DiscountPolicy {
    private static final BigDecimal VIP_RATE = BigDecimal.valueOf(0.9);
    private static final String COUPON10 = "COUPON10";

    @Override
    public BigDecimal applyDiscount(BigDecimal price, CheckoutRequest request) {
        BigDecimal result = price;
        if (request.isVip()) {
            result = result.multiply(VIP_RATE);
        }
        if (COUPON10.equalsIgnoreCase(request.getCoupon())) {
            result = result.subtract(BigDecimal.TEN);
        }
        return result.max(BigDecimal.ZERO);
    }
}
