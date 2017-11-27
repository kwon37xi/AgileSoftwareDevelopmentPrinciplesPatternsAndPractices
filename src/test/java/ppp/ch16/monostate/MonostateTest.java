package ppp.ch16.monostate;//import static org.junit.Assert.*;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MonostateTest {

    @Test
    public void instance() throws Exception {
        Monostate m = new Monostate();
        for (int x = 0; x < 10; x++) {
            m.setX(x);
            assertThat(x).isEqualTo(m.getX());
        }
    }

    @Test
    public void instancesBehaveAsOne() throws Exception {
        Monostate m1 = new Monostate();
        Monostate m2 = new Monostate();

        for (int x = 0; x < 10; x++) {
            m1.setX(x);
            assertThat(m2.getX()).isEqualTo(x);
        }
    }
}