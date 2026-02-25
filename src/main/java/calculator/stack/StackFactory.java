package calculator.stack;

import calculator.list.*;

public class StackFactory {

    public static Stack<String> createStack(int option, int listOption) {

        switch (option) {
            case 1:
                return new StackArrayList<>();

            case 2:
                return new StackVector<>();

            case 3:
                ListADT<String> list = ListFactory.createList(listOption);
                return new StackList<>(list);

            default:
                throw new IllegalArgumentException("Opción inválida");
        }
    }
}
