package ppp.ch24.c_timesinkobserver;

public interface  TimeSource {
    void setObserver(ClockObserver driver);
}
