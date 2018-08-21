package win.elegentjs.datastructor.stack;

import java.util.Random;

public class TestStack {

    public static void main(String[] args) {
        EnhancedStack stack = new EnhancedStack(10);

        for (int index = 0; index < 1000; index ++) {
            int randInt = new Random().nextInt(10);
            System.out.println("push: " + randInt);
            stack.push(randInt);
        }

        System.out.println();

        System.out.println("peek: " + stack.peek());


        System.out.println();


        for (int index = 0; index < 1000; index ++) {
            System.out.println("pop: " + stack.pop());
        }


        String s = "how are you";
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            stack.push(c);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

        System.out.println();

    }
}
