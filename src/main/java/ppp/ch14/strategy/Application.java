package ppp.ch14.strategy;

/**
 * Strategy
 */
public interface Application {
    void init();

    boolean done();

    void idle();

    void cleanup();
}
