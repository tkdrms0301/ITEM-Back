package kit.item.enums;

public enum RepairServiceType {
    모바일(1),
    태블릿(2),
    노트북(3),
    컴퓨터(4);
    private final int value;
    RepairServiceType(int value) { this.value = value; }

    public int getValue() { return value; }
}
