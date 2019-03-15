package win.elegentjs.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

public class MyObserver1 implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("MyObserver1 invoked. ");
    }
}
