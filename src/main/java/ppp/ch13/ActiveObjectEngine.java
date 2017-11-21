package ppp.ch13;

import java.util.LinkedList;

/**
 * 13장 Active Object Pattern
 */
public class ActiveObjectEngine {
    private LinkedList<Command> itsCommands = new LinkedList<>();

    public void addCommand(Command c) {
        itsCommands.add(c);
    }

    public void run() {
        while (!itsCommands.isEmpty()) {
            Command c = itsCommands.getFirst();
            itsCommands.removeFirst();
            c.execute();
        }
    }
}
