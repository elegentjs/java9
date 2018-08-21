package win.elegentjs.datastructor.reversepolish;

import com.elegentjs.stack.Stack;

import java.util.Scanner;

/**
 * 中缀表达式转换为后缀表达式（reversePolish）
 */
public class InfixToSuffix {

    // 操作符栈
    private Stack s1;

    // 存储结果栈
    private Stack s2;

    // 输入的中缀表达式
    private String input;


    public InfixToSuffix(String input) {
        this.input = input;

        s1 = new Stack(input.length());
        s2 = new Stack(input.length());
    }


    /**
     * 执行中缀转后缀
     * @return
     */
    public Stack doTrans() {
        for (int index = 0; index < input.length(); index ++) {
            char c = input.charAt(index);

            if (c == ' ') {
                continue;
            }

            System.out.println("当前解析的字符：" + c);

            switch (c) {
                case '+':
                case '-':

                    gotOper(c, 1);
                    break;
                case '*':
                case '/':
                    gotOper(c, 2);
                    break;
                case '(':
                    s1.push(c);
                    break;
                case ')':
                    gotParen();
                    break;

                default:
                    s2.push(c);
                    break;
            }


            System.out.print("操作符栈s1： ");
            s1.displayReverse();

            System.out.print("存储结果栈s2： ");
            s2.displayReverse();

            System.out.println();
        }


        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }



        return s2;
    }

    /**
     * 获取的字符是小括号（')'）
     */
    private void gotParen() {
        while (!s1.isEmpty()) {
            char top = (char) s1.pop();

            if (top == '(') {
                break;
            } else {
                s2.push(top);
            }
        }

    }


    /**
     *
     * @param c 当前操作符
     * @param priority 当前字符优先级
     */
    private void gotOper(char c, int priority) {
        while (!s1.isEmpty()) {
            char top = (char) s1.peek();

            if (top == '(') {
                break;
            } else {
                int topPriority;

                if (top == '+' || top == '-') {
                    topPriority = 1;
                } else {
                    topPriority = 2;
                }

                if (priority > topPriority) {
                    break;
                } else {
                    s1.pop();
                    s2.push(top);
                }


            }

        }

        // 操作符压入栈
        s1.push(c);

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("/");

        System.out.println("请输入一段中缀表达式，程序将转换为后缀表达式输出, 或输入quit结束程序。");

        String expression = scanner.nextLine();

        while (!expression.equals("quit")) {
            InfixToSuffix infixToSuffix = new InfixToSuffix(expression);
            Stack stack = infixToSuffix.doTrans();

            System.out.println(expression + " 对应的逆波兰表达式是：");
            stack.displayReverse();

            System.out.println("请输入一段中缀表达式，程序将转换为后缀表达式输出, 或输入quit结束程序。");
            expression = scanner.next();
        }


    }

}
