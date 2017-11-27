package ppp.ch16.monostate;

/**
 * Monostate Pattern 기본 예제
 */
public class Monostate {
    private static int itsX = 0;

    public Monostate() {
    }

    public void setX(int x) {
        itsX = x;
    }

    public int getX() {
        return itsX;
    }
}
