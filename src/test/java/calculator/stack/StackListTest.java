package calculator.stack;

import calculator.list.SimpleLinkedList;
import calculator.list.DoublyLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackListTest {

    @Test
    void withSimpleLinkedList_pushAndPop() {
        StackList<Integer> stack = new StackList<>(new SimpleLinkedList<>());
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void withSimpleLinkedList_lifoOrder() {
        StackList<Integer> stack = new StackList<>(new SimpleLinkedList<>());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void withSimpleLinkedList_peek() {
        StackList<Integer> stack = new StackList<>(new SimpleLinkedList<>());
        stack.push(42);
        assertEquals(42, stack.peek());
        assertFalse(stack.isEmpty());
    }

    @Test
    void withDoublyLinkedList_pushAndPop() {
        StackList<Integer> stack = new StackList<>(new DoublyLinkedList<>());
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void withDoublyLinkedList_lifoOrder() {
        StackList<Integer> stack = new StackList<>(new DoublyLinkedList<>());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void withDoublyLinkedList_peek() {
        StackList<Integer> stack = new StackList<>(new DoublyLinkedList<>());
        stack.push(42);
        assertEquals(42, stack.peek());
        assertFalse(stack.isEmpty());
    }

    @Test
    void newStackIsEmpty() {
        StackList<Integer> stack = new StackList<>(new SimpleLinkedList<>());
        assertTrue(stack.isEmpty());
    }

    @Test
    void pushPopMultipleCycles() {
        StackList<Integer> stack = new StackList<>(new DoublyLinkedList<>());
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }
}
