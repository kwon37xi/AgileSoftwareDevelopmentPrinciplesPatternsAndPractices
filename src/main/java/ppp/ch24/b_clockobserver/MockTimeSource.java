package ppp.ch24.b_clockobserver;

public class MockTimeSource implements TimeSource {

    private ClockObserver itsObserver;

    @Override
    public void setObserver(ClockObserver driver) {
        itsObserver = driver;
    }

    public void setTime(int hours, int minutes, int seconds) {
        itsObserver.update(hours, minutes, seconds);
    }
}
