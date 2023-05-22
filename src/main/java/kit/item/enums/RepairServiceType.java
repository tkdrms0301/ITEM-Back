package kit.item.enums;

public enum RepairServiceType {
    MOBILE(1),
    TABLET(2),
    NOTEBOOK(3),
    COMPUTER(4);
    private final int value;
    RepairServiceType(int value) { this.value = value; }

    public int getValue() { return value; }
}
