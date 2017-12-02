package ppp.ch24.a_beforeobserverpattern;

public class ClockDriver {
    private TimeSink itsSink;

    public ClockDriver(TimeSource source, TimeSink sink) {
        source.setDriver(this);
        itsSink = sink;
    }

    public void update(int hours, int minutes, int seconds) {
        itsSink.setTime(hours, minutes, seconds);
    }
}
