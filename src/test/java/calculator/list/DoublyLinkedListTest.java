package calculator.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    private DoublyLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new DoublyLinkedList<>();
    }

    @Test
    void newListHasSizeZero() {
        assertEquals(0, list.size());
    }

    @Test
    void addLastIncrementsSize() {
        list.addLast(1);
        assertEquals(1, list.size());
        list.addLast(2);
        assertEquals(2, list.size());
    }

    @Test
    void getLastReturnsMostRecentElement() {
        list.addLast(10);
        assertEquals(10, list.getLast());
        list.addLast(20);
        assertEquals(20, list.getLast());
    }

    @Test
    void removeLastReturnsAndRemovesLastElement() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertEquals(3, list.removeLast());
        assertEquals(2, list.size());
        assertEquals(2, list.removeLast());
        assertEquals(1, list.removeLast());
        assertEquals(0, list.size());
    }

    @Test
    void removeLastOnEmptyReturnsNull() {
        assertNull(list.removeLast());
    }

    @Test
    void getLastOnEmptyReturnsNull() {
        assertNull(list.getLast());
    }

    @Test
    void singleElementAddAndRemove() {
        list.addLast(42);
        assertEquals(42, list.removeLast());
        assertEquals(0, list.size());
    }
}
