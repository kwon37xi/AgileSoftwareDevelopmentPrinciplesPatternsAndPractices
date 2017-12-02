package ppp.ch24.a_beforeobserverpattern;

public class MockTimeSource implements TimeSource {

    private ClockDriver itsDriver;

    @Override
    public void setDriver(ClockDriver driver) {
        itsDriver = driver;
    }

    public void setTime(int hours, int minutes, int seconds) {
        itsDriver.update(hours, minutes, seconds);
    }
}
