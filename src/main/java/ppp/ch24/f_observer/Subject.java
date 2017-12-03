package ppp.ch24.f_observer;

import java.util.Iterator;
import java.util.Vector;

public class Subject {
    private Vector<Observer> itsObservers = new Vector<>();

    protected void notifyObservers() {
        Iterator<Observer> i = itsObservers.iterator();

        while (i.hasNext()) {
            Observer observer = i.next();
            observer.update();
        }
    }

    public void registerObserver(Observer observer) {
        itsObservers.add(observer);
    }
}
