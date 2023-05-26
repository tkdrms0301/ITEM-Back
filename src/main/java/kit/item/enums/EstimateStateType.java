package kit.item.enums;

public enum EstimateStateType {
    WAITING("응답 대기"),
    COMPLETED("응답 완료");

    private String krName;
    EstimateStateType(String krName) { this.krName = krName; }
    public String getKrName() { return krName; }
}
