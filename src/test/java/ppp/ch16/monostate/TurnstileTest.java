package ppp.ch16.monostate;//import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TurnstileTest {
    @Before
    public void setUp() throws Exception {
        Turnstile t = new Turnstile.Unlocked();
        t.reset();
    }

    @Test
    public void init() throws Exception {
        Turnstile t = new Turnstile();
        assertThat(t.locked()).isTrue();
        assertThat(t.alarm()).isFalse();
    }

    @Test
    public void coin() throws Exception {
        Turnstile t = new Turnstile();
        t.coin();
        Turnstile t1 = new Turnstile();

        assertThat(t1.locked()).isFalse();
        assertThat(t1.alarm()).isFalse();
        assertThat(t1.coins()).isEqualTo(1);
    }

    @Test
    public void coinAndPass() throws Exception {
        Turnstile t = new Turnstile();
        t.coin();
        t.pass();

        Turnstile t1 = new Turnstile();

        assertThat(t1.locked()).isTrue();
        assertThat(t1.alarm()).isFalse();
        assertThat(t1.coins()).as("coins").isEqualTo(1);
    }

    @Test
    public void twoCoins() throws Exception {
        Turnstile t = new Turnstile();
        t.coin();
        t.coin();

        Turnstile t1 = new Turnstile();
        assertThat(t1.locked()).as("unlocked").isFalse();
        assertThat(t1.coins()).as("coins").isEqualTo(1);
        assertThat(t1.refunds()).as("refunds").isEqualTo(1);
        assertThat(t1.alarm()).isFalse();
    }

    @Test
    public void pass() throws Exception {
        Turnstile t = new Turnstile();
        t.pass();

        Turnstile t1 = new Turnstile();
        assertThat(t1.alarm()).as("alarm").isTrue();
        assertThat(t1.locked()).as("locked").isTrue();
    }

    @Test
    public void cancelAlarm() throws Exception {
        Turnstile t = new Turnstile();
        t.pass();
        t.coin();

        Turnstile t1 = new Turnstile();
        assertThat(t1.alarm()).as("alarm").isFalse();
        assertThat(t1.locked()).as("locked").isFalse();
        assertThat(t1.coins()).as("coins").isEqualTo(1);
        assertThat(t1.refunds()).as("refund").isEqualTo(0);
    }

    @Test
    public void twoOperations() throws Exception {
        Turnstile t = new Turnstile();
        t.coin();
        t.pass();
        t.coin();

        assertThat(t.locked()).as("unlocked").isFalse();
        assertThat(t.coins()).as("coins").isEqualTo(2);
        t.pass();
        assertThat(t.locked()).as("locked").isTrue();
    }
}