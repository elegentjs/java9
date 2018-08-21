package win.elegentjs.thinkinginjava.inter;

public class Downcase extends Processor {
    @Override
    Object process(Object input) {
        return ((String) input).toLowerCase();
    }
}
