public class MainRefTest {
    public static void main(String[] args) {
        var svc = new RefactoredOrderService(
                new DefaultPricingPolicy(),
                new CombinedDiscountPolicy(),
                new MockOrderRepository());

        // 정상 케이스
        var req = new CheckoutRequest("vip001", "A-100", 2, true, "COUPON10");
        Receipt r = svc.checkout(req);
        System.out.println(r);

        // 검증 실패
        try {
            svc.checkout(new CheckoutRequest("", "A-100", -1, false, ""));
        } catch (ValidationException e) {
            System.out.println("PASS: " + e.getMessage());
        }

        // 재고 부족
        try {
            svc.checkout(new CheckoutRequest("u1", "B-100", 99, false, ""));
        } catch (OutOfStockException e) {
            System.out.println("PASS: " + e.getMessage());
        }
    }
}