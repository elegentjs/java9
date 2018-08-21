package win.elegentjs.thinkinginjava.inter;

public class Apply {


    public static void process(Processor processor, Object s) {
        System.out.println(processor.process(s));
    }


    public static void main(String[] args) {
        String s = "hello World";

        process(new Upcase(), s);
        process(new Downcase(), s);
        process(new Splitter(), s);

    }

}
