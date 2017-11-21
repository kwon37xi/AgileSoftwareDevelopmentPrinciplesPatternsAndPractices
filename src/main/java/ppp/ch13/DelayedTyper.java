package ppp.ch13;

public class DelayedTyper implements Command {
    private long itsDelay;
    private char itsChar;
    private static ActiveObjectEngine engine = new ActiveObjectEngine();
    private static boolean stop = false;

    public DelayedTyper(long delay, char c) {
        itsDelay = delay;
        itsChar = c;
    }

    /**
     * 지정된 시간이 지나면 문자를 출력하고 다시 SleepCommand를 통해 지정된 시간을 기다리게 함.
     */
    @Override
    public void execute() {
        System.out.print(itsChar);
        if (!stop) {
            delayAndRepeat();
        }
    }

    private void delayAndRepeat() {
        engine.addCommand(new SleepCommand(itsDelay, engine, this));
    }

    public static void main(String[] args) {
        engine.addCommand(new DelayedTyper(100, '1'));
        engine.addCommand(new DelayedTyper(300, '3'));
        engine.addCommand(new DelayedTyper(500, '5'));
        engine.addCommand(new DelayedTyper(700, '7'));

        Command stopCommand = () -> stop = true;

        // 20초 후에 실행 중단.
        engine.addCommand(new SleepCommand(20000, engine, stopCommand));

        long startedAt = System.currentTimeMillis();
        engine.run();
        long endAt = System.currentTimeMillis();

        System.out.printf("%nRunning %d ~ %d : %d%n", startedAt, endAt, endAt - startedAt);
    }
}
