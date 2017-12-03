package ppp.ch24.c_timesinkobserver;

public interface ClockObserver {
    void update(int hours, int minutes, int seconds);
}
