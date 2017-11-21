package ppp.ch13;

/**
 * SleepCommand는 실행 시점이 될 때까지 자기 자신을 복제하여 큐의 맨 뒤에 넣기 때문에
 * 그 사이에 있던 다른 명령들을 실행하고 나서 나중에 wakeupCommand를 실행한다.
 */
public class SleepCommand implements Command {
    private Command wakeupCommand = null;
    private ActiveObjectEngine engine = null;
    private long sleepTime = 0;
    private long startTime = 0;
    private boolean started = false;

    public SleepCommand(long milliseconds, ActiveObjectEngine e, Command wakeupCommand) {
        sleepTime = milliseconds;
        engine = e;
        this.wakeupCommand = wakeupCommand;
    }

    @Override
    public void execute() {
        long currentTime = System.currentTimeMillis();
        if (!started) {
            started = true;
            startTime = currentTime;
            engine.addCommand(this);
        } else if ((currentTime - startTime) < sleepTime) {
            engine.addCommand(this);
        } else {
            engine.addCommand(wakeupCommand);
        }
    }
}
