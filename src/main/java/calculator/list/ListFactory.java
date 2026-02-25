package calculator.list;

public class ListFactory {

    public static ListADT<String> createList(int option) {

        switch (option) {
            case 1:
                return new SimpleLinkedList<>();

            case 2:
                return new DoublyLinkedList<>();

            default:
                throw new IllegalArgumentException("Opción inválida");
        }
    }
}