package uvg.edu.gt.list;

public class SimpleLinkedList<T> extends AbstractList<T> {

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;

    @Override
    public void addLast(T item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    @Override
    public T removeLast() {
        if (head == null)
            return null;

        if (head.next == null) {
            T data = head.data;
            head = null;
            size--;
            return data;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        T data = temp.next.data;
        temp.next = null;
        size--;
        return data;
    }

    @Override
    public T getLast() {
        if (head == null)
            return null;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        return temp.data;
    }
}
