package uvg.edu.gt.list;

public class DoublyLinkedList<T> extends AbstractList<T> {

    private class Node {
        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;

    @Override
    public void addLast(T item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T removeLast() {
        if (tail == null)
            return null;

        T data = tail.data;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
        return data;
    }

    @Override
    public T getLast() {
        if (tail == null)
            return null;
        return tail.data;
    }
}
