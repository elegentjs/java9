package win.elegentjs.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

public class MyObserver3 implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("MyObserver3 invoked. ");
    }
}
