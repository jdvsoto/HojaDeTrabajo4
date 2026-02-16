package uvg.edu.gt.calculator;

import uvg.edu.gt.stack.Stack;

public class Calculator {

    private Stack<String> stack;

    public Calculator(Stack<String> stack) {
        this.stack = stack;
    }

    private int precedence(String op) {
        if (op.equals("+") || op.equals("-"))
            return 1;
        if (op.equals("*") || op.equals("/"))
            return 2;
        return 0;
    }

    public String infixToPostfix(String expression) {

        StringBuilder output = new StringBuilder();
        String number = "";

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                number += c;
            } else {

                if (!number.isEmpty()) {
                    output.append(number).append(" ");
                    number = "";
                }

                if (c == '(') {
                    stack.push(String.valueOf(c));
                } else if (c == ')') {
                    while (!stack.peek().equals("(")) {
                        output.append(stack.pop()).append(" ");
                    }
                    stack.pop();
                } else {
                    while (!stack.isEmpty() &&
                            precedence(stack.peek()) >= precedence(String.valueOf(c))) {
                        output.append(stack.pop()).append(" ");
                    }
                    stack.push(String.valueOf(c));
                }
            }
        }

        if (!number.isEmpty()) {
            output.append(number).append(" ");
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop()).append(" ");
        }

        return output.toString().trim();
    }

    public int evaluatePostfix(String postfix) {

        String[] tokens = postfix.split(" ");

        for (String token : tokens) {

            if (token.matches("\\d+")) {
                stack.push(token);
            } else {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());

                int result = 0;

                if (token.equals("+"))
                    result = a + b;
                if (token.equals("-"))
                    result = a - b;
                if (token.equals("*"))
                    result = a * b;
                if (token.equals("/"))
                    result = a / b;

                stack.push(String.valueOf(result));
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
