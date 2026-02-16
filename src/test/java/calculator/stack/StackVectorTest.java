package calculator.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackVectorTest {

    private StackVector<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new StackVector<>();
    }

    @Test
    void newStackIsEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void pushMakesStackNonEmpty() {
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    void pushAndPop() {
        stack.push(10);
        assertEquals(10, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void pushAndPeek() {
        stack.push(5);
        assertEquals(5, stack.peek());
        assertFalse(stack.isEmpty());
    }

    @Test
    void lifoOrder() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void popOnEmptyThrows() {
        assertThrows(Exception.class, () -> stack.pop());
    }

    @Test
    void peekOnEmptyThrows() {
        assertThrows(Exception.class, () -> stack.peek());
    }

    @Test
    void pushPopMultipleCycles() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }
}
