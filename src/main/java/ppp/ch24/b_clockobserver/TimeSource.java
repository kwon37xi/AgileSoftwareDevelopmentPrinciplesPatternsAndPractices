package ppp.ch24.b_clockobserver;

public interface  TimeSource {
    void setObserver(ClockObserver driver);
}
