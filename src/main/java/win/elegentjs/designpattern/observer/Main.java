package win.elegentjs.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

public class Main {

    public static void main(String[] args) {
        MyObservable observable = new MyObservable();

        Observer observer1 = new MyObserver1();
        Observer observer2 = new MyObserver2();
        Observer observer3 = new MyObserver3();

        observable.addObserver(observer1);
        observable.addObserver(observer2);
        observable.addObserver(observer3);

        observable.changed();

        observable.notifyObservers();
    }
}
