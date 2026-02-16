package calculator.main;

import calculator.stack.*;
import calculator.list.*;
import calculator.calculator.Calculator;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        System.out.println("Seleccione implementación de Stack:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista");

        int option = input.nextInt();

        Stack<String> stack = null;

        if (option == 1) {
            stack = new StackArrayList<>();
        } else if (option == 2) {
            stack = new StackVector<>();
        } else if (option == 3) {

            System.out.println("Seleccione implementación de Lista:");
            System.out.println("1. Simplemente encadenada");
            System.out.println("2. Doblemente encadenada");

            int listOption = input.nextInt();

            if (listOption == 1) {
                stack = new StackList<>(new SimpleLinkedList<>());
            } else {
                stack = new StackList<>(new DoublyLinkedList<>());
            }
        }

        Scanner file = new Scanner(new File("datos.txt"));
        String expression = file.nextLine();
        file.close();

        Calculator calculator = new Calculator(stack);

        String postfix = calculator.infixToPostfix(expression);
        System.out.println("Postfix: " + postfix);

        int result = calculator.evaluatePostfix(postfix);
        System.out.println("Resultado: " + result);
    }
}
