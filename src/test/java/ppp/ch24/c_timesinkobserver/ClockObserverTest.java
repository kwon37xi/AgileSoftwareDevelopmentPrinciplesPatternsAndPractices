package ppp.ch24.c_timesinkobserver;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClockObserverTest {

    @Test
    public void testTimeChange() {
        MockTimeSource source = new MockTimeSource();
        MockTimeSink sink = new MockTimeSink();

        source.setObserver(sink);

        source.setTime(3, 4, 5);
        assertThat(sink.getHours()).isEqualTo(3);
        assertThat(sink.getMinutes()).isEqualTo(4);
        assertThat(sink.getSeconds()).isEqualTo(5);

        source.setTime(7, 8, 9);
        assertThat(sink.getHours()).isEqualTo(7);
        assertThat(sink.getMinutes()).isEqualTo(8);
        assertThat(sink.getSeconds()).isEqualTo(9);
    }
}