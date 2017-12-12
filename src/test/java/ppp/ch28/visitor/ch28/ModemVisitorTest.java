package ppp.ch28.visitor.ch28;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ModemVisitorTest {
    private UnixModemConfigurator v;
    private HayesModem h;
    private ZoomModem z;
    private ErnieModem e;

    @Before
    public void setUp() throws Exception {
        v = new UnixModemConfigurator();
        h = new HayesModem();
        z = new ZoomModem();
        e = new ErnieModem();
    }

    @Test
    public void testHayesForUnix() {
        h.accept(v);
        assertThat(h.configurationString).isEqualTo("&s1=4&D=3");
    }

    @Test
    public void testZoomForUnix() {
        z.accept(v);
        assertThat(z.configurationValue).isEqualTo(42);
    }

    @Test
    public void testErnieForUnix() {
        e.accept(v);
        assertThat(e.internalPattern).isEqualTo("C is too slow");
    }
}