package ppp.ch06;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    private Game g;

    @Before
    public void setUp() throws Exception {
        g = new Game();
    }

    @Test
    public void testTwoThrowsNoMark() {
        g.add(5);
        g.add(4);
        assertThat(g.score()).isEqualTo(9);
    }

    @Test
    public void testFourThrowsNoMark() throws Exception {
        g.add(5);
        g.add(4);
        g.add(7);
        g.add(2);

        assertThat(g.score()).isEqualTo(18);
        assertThat(g.scoreForFrame(1)).isEqualTo(9);
        assertThat(g.scoreForFrame(2)).isEqualTo(18);
    }

    @Test
    public void testSimpleSpare() throws Exception {
        g.add(3);
        g.add(7);
        g.add(3);
        assertThat(g.scoreForFrame(1)).isEqualTo(13);
    }

    @Test
    public void testSimpleFrameAfterSpare() throws Exception {
        g.add(3);
        g.add(7);
        g.add(3);
        g.add(2);
        assertThat(g.scoreForFrame(1)).isEqualTo(13);
        assertThat(g.scoreForFrame(2)).isEqualTo(18);
        assertThat(g.score()).isEqualTo(18);
    }

    @Test
    public void testSimpleStrike() throws Exception {
        g.add(10);
        g.add(3);
        g.add(6);
        assertThat(g.scoreForFrame(1)).isEqualTo(19);
        assertThat(g.score()).isEqualTo(28);
    }

    @Test
    public void testPerfectGame() throws Exception {
        for (int i = 0; i < 12; i++) {
            g.add(10);
        }

        assertThat(g.score()).isEqualTo(300);
    }

    @Test
    public void testEndOfArray() throws Exception {
        for (int i = 0; i < 9; i++) {
            g.add(0);
            g.add(0);
        }

        g.add(2);
        g.add(8);
        g.add(10);
        assertThat(g.score()).isEqualTo(20);
    }

    @Test
    public void testSampleGame() throws Exception {
        g.add(1);
        g.add(4);
        g.add(4);
        g.add(5);
        g.add(6);
        g.add(4);
        g.add(5);
        g.add(5);
        g.add(10);
        g.add(0);
        g.add(1);
        g.add(7);
        g.add(3);
        g.add(6);
        g.add(4);
        g.add(10);
        g.add(2);
        g.add(8);
        g.add(6);

        assertThat(g.score()).isEqualTo(133);
    }

    @Test
    public void testHeartBreak() throws Exception {
        for (int i = 0; i < 11; i++)
            g.add(10);

        g.add(9);

        assertThat(g.score()).isEqualTo(299);
    }

    @Test
    public void testTenthFrameSpare() throws Exception {
        for (int i = 0; i < 9; i++)
            g.add(10);

        g.add(9);
        g.add(1);
        g.add(1);

        assertThat(g.score()).isEqualTo(270);
    }
}