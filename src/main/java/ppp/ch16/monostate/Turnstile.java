package ppp.ch16.monostate;

public class Turnstile {
    private static boolean isLocked = true;
    private static boolean isAlarming = false;
    private static int itsCoins = 0;
    private static int itsRefunds = 0;
    protected final static Turnstile LOCKED = new Locked();
    protected final static Turnstile UNLOCKED = new Unlocked();
    protected static Turnstile itsState = LOCKED;

    public void reset() {
        lock(true);
        alarm(false);
        itsCoins = 0;
        itsRefunds = 0;
        itsState = LOCKED;
    }

    public boolean locked() {
        return isLocked;
    }

    public boolean alarm() {
        return isAlarming;
    }

    public void coin() {
        itsState.coin();
    }

    public void pass() {
        itsState.pass();
    }

    protected void lock(boolean shouldLock) {
        isLocked = shouldLock;
    }

    protected void alarm(boolean shouldAlarm) {
        isAlarming = shouldAlarm;
    }

    public int coins() {
        return itsCoins;
    }

    public int refunds() {
        return itsRefunds;
    }

    public void deposit() {
        itsCoins++;
    }

    public void refund() {
        itsRefunds++;
    }

    static class Locked extends Turnstile {
        @Override
        public void coin() {
            itsState = UNLOCKED;
            lock(false);
            alarm(false);
            deposit();
        }

        @Override
        public void pass() {
            alarm(true);
        }
    }

    static class Unlocked extends Turnstile {
        @Override
        public void coin() {
            refund();
        }

        @Override
        public void pass() {
            lock(true);
            itsState = LOCKED;
        }
    }
}
