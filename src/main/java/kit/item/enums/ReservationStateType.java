package kit.item.enums;

public enum ReservationStateType {
    WAITING("예약 대기"),
    ACCEPTED("예약 완료"),
    REJECTED("거절"),
    COMPLETED("정비 완료");

    private String krName;
    ReservationStateType(String krName) { this.krName = krName; }
    public String getKrName() { return krName; }
}
