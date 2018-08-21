package win.elegentjs.thinkinginjava.inter;

public class Processor {

    public String getName() {
        return getClass().getSimpleName();
    }

    Object process(Object input) {
        return input;
    }

}
