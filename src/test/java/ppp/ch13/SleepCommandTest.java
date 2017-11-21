package ppp.ch13;//import static org.junit.Assert.*;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SleepCommandTest {
    private boolean commandExecuted = false;

    @Test
    public void testSleep() throws Exception {
        Command wakeup = () -> commandExecuted = true;

        ActiveObjectEngine e = new ActiveObjectEngine();
        SleepCommand c = new SleepCommand(1000, e, wakeup);
        e.addCommand(c);

        long start = System.currentTimeMillis();
        e.run();
        long stop = System.currentTimeMillis();

        long sleepTime = (stop - start);

        assertThat(sleepTime).as("SleepTime %d expected >= 1000", sleepTime).isGreaterThanOrEqualTo(1000);
        assertThat(sleepTime).as("SleepTime %d expected < 1000", sleepTime).isLessThan(1100);
        assertThat(commandExecuted).as("CommandExcuted").isTrue();
    }
}