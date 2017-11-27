package ppp.ch16.singletone;//import static org.junit.Assert.*;

import org.junit.Test;
import ppp.ch16.singleton.Singleton;

import java.lang.reflect.Constructor;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    public void createSingleton() throws Exception {
        Singleton s = Singleton.instance();
        Singleton s2 = Singleton.instance();

        assertThat(s).isSameAs(s2);
    }

    @Test
    public void noPublicConstructors() throws Exception {
        Class singleton = Class.forName("ppp.ch16.singleton.Singleton");
        Constructor[] constructors = singleton.getConstructors();
        assertThat(constructors.length).as("no public constructors").isEqualTo(0);
    }
}