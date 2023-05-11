package kit.item.enums;

public enum ReportValueType {
    SALE_PRODUCT_REPORT(0),
    MARKET_REVIEW_REPORT(1),
    REPAIR_REVIEW_REPORT(2),
    POST_REPORT(3),
    COMMENT_REPORT(4),
    REPAIR_RESULT_REPORT(5);
    private final int value;
    ReportValueType(int value) { this.value = value; }

    public int getValue() { return value; }
}
