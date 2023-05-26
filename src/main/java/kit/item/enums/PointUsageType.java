package kit.item.enums;

public enum PointUsageType {
    MARKET_REVIEW(0, "마켓 리뷰 작성"),
    REPAIR_SERVICE_REVIEW(1, "수리 서비스 리뷰 작성"),
    PRODUCT_SALE(2, "상품 판매"),
    PRODUCT_PURCHASE(3, "상품 구매"),
    REPAIR_SERVICE_PROVIDE(4, "수리 서비스 제공"),
    REPAIR_SERVICE_USE(5, "수리 서비스 이용"),
    SUBSCRIPTION_PURCHASE(6, "구독 상품 구매");

    private final int value;
    private final String krName;
    PointUsageType(int value, String krName) { this.value = value; this.krName = krName; }

    public int getValue() { return value; }
    public String getKrName() { return krName; }
}
