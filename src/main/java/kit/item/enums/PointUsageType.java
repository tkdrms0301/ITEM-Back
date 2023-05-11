package kit.item.enums;

public enum PointUsageType {
    MARKET_REVIEW(0),
    REPAIR_SERVICE_REVIEW(1),
    PRODUCT_SALE(2),
    PRODUCT_PURCHASE(3),
    REPAIR_SERVICE_PROVIDE(4),
    REPAIR_SERVICE_USE(5),
    SUBSCRIPTION_PURCHASE(6);

    private final int value;
    PointUsageType(int value) { this.value = value; }

    public int getValue() { return value; }
}
