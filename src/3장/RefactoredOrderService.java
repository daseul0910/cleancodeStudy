import java.math.BigDecimal;

public class RefactoredOrderService {
    private final PricingPolicy pricingPolicy;
    private final DiscountPolicy discountPolicy;
    private final MockOrderRepository repository;

    public RefactoredOrderService(PricingPolicy pricingPolicy, DiscountPolicy discountPolicy,
            MockOrderRepository repository) {
        this.pricingPolicy = pricingPolicy;
        this.discountPolicy = discountPolicy;
        this.repository = repository;
    }

    public Receipt checkout(CheckoutRequest req) {
        validate(req);
        checkStock(req.getItemId(), req.getQuantity());

        BigDecimal basePrice = pricingPolicy.calculateBasePrice(req.getItemId(), req.getQuantity());
        BigDecimal discounted = discountPolicy.applyDiscount(basePrice, req);

        String orderId = repository.save(req.getUserId(), req.getItemId(), req.getQuantity(), discounted);
        return new Receipt(orderId, req.getUserId(), req.getItemId(), req.getQuantity(), discounted);
    }

    private void validate(CheckoutRequest req) {
        if (req.getUserId() == null || req.getUserId().trim().isEmpty()) {
            throw new ValidationException("USER_REQUIRED");
        }
        if (req.getItemId() == null || req.getItemId().trim().isEmpty()) {
            throw new ValidationException("ITEM_REQUIRED");
        }
        if (req.getQuantity() <= 0) {
            throw new ValidationException("QTY_POSITIVE");
        }
    }

    private void checkStock(String itemId, int qty) {
        if (qty > 20) {
            throw new OutOfStockException("OUT_OF_STOCK");
        }
    }
}
