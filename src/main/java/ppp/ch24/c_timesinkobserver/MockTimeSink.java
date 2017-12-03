package ppp.ch24.c_timesinkobserver;

public class MockTimeSink implements ClockObserver {
    private int itsHours;
    private int itsMinutes;
    private int itsSeconds;

    public int getHours() {
        return itsHours;
    }

    public int getMinutes() {
        return itsMinutes;
    }

    public int getSeconds() {
        return itsSeconds;
    }

    @Override
    public void update(int hours, int minutes, int seconds) {
        itsHours = hours;
        itsMinutes = minutes;
        itsSeconds = seconds;
    }
}
