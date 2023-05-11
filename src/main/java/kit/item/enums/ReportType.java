package kit.item.enums;

public enum ReportType {
    SPAM(0),
    INAPPROPRIATE(1),
    ETC(2);


    private final int value;
    ReportType(int value) { this.value = value; }

    public int getValue() { return value; }
}
