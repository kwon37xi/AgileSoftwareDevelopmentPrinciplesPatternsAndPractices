package ppp.ch16;

/**
 * 기본 싱글턴 패턴 구현.
 * 실제로는 잘못된 코드이다.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Double-checked_locking#Usage_in_Java">Double Checked Locking usage in Java</a>
 */
public class Singleton {
    private static Singleton theInstance = null;

    private Singleton() {

    }

    public static Singleton instance() {
        if (theInstance == null) {
            theInstance = new Singleton();
        }
        return theInstance;
    }
}
