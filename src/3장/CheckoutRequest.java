public class CheckoutRequest {
    private final String userId;
    private final String itemId;
    private final int quantity;
    private final boolean vip;
    private final String coupon;

    public CheckoutRequest(String userId, String itemId, int quantity, boolean vip, String coupon) {
        this.userId = userId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.vip = vip;
        this.coupon = coupon;
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

    public boolean isVip() {
        return vip;
    }

    public String getCoupon() {
        return coupon;
    }
}
