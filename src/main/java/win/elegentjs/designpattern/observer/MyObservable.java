package win.elegentjs.designpattern.observer;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class MyObservable extends Observable {
    public void changed() {
        setChanged();
    }
}
