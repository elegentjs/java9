package win.elegentjs.datastructor.reversepolish;

import com.elegentjs.stack.Stack;

public class CalSuffix {

    private Stack stack;
    private String input;

    public CalSuffix(String input) {
        this.input = input;
        stack = new Stack(input.length());
    }

    public int doCalc() {
        int num1, num2, result;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= '0' && c <= '9') {
                //如果是数字，直接压入栈中
                stack.push(c - '0');
            } else {
                //注意先出来的为第二个操作数
                num2 = stack.pop();
                num1 = stack.pop();
                switch (c) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                    default:
                        result = 0;
                        break;
                }//end switch

                stack.push(result);
            }//end else
        }//end for
        result = stack.pop();
        return result;
    }

    public static void main(String[] args) {
        CalSuffix cs = new CalSuffix("354-*1+");
        System.out.println(cs.doCalc()); //4
    }

}
