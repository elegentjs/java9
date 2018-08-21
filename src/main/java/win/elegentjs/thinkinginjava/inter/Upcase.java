package win.elegentjs.thinkinginjava.inter;

public class Upcase extends Processor {
    @Override
    Object process(Object input) {
        return ((String) input).toUpperCase();
    }
}
