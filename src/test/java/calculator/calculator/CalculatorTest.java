package calculator.calculator;

import calculator.stack.StackArrayList;
import calculator.stack.StackVector;
import calculator.stack.StackList;
import calculator.list.SimpleLinkedList;
import calculator.list.DoublyLinkedList;
import calculator.stack.Stack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator newCalculator() {
        return new Calculator(new StackArrayList<>());
    }

    // --- infixToPostfix ---

    @Test
    void simpleAddition() {
        Calculator calc = newCalculator();
        assertEquals("3 4 +", calc.infixToPostfix("3+4"));
    }

    @Test
    void simpleMultiplication() {
        Calculator calc = newCalculator();
        assertEquals("3 4 *", calc.infixToPostfix("3*4"));
    }

    @Test
    void precedenceMultiplicationBeforeAddition() {
        Calculator calc = newCalculator();
        assertEquals("3 4 2 * +", calc.infixToPostfix("3+4*2"));
    }

    @Test
    void parenthesesOverridePrecedence() {
        Calculator calc = newCalculator();
        assertEquals("10 20 + 9 *", calc.infixToPostfix("(10+20)*9"));
    }

    @Test
    void multiDigitNumbers() {
        Calculator calc = newCalculator();
        assertEquals("100 200 +", calc.infixToPostfix("100+200"));
    }

    @Test
    void nestedParentheses() {
        Calculator calc = newCalculator();
        assertEquals("1 2 3 + *", calc.infixToPostfix("1*(2+3)"));
    }

    // --- evaluatePostfix ---

    @Test
    void evaluateSimpleAddition() {
        Calculator calc = newCalculator();
        assertEquals(7, calc.evaluatePostfix("3 4 +"));
    }

    @Test
    void evaluateSimpleSubtraction() {
        Calculator calc = newCalculator();
        assertEquals(6, calc.evaluatePostfix("10 4 -"));
    }

    @Test
    void evaluateSimpleMultiplication() {
        Calculator calc = newCalculator();
        assertEquals(12, calc.evaluatePostfix("3 4 *"));
    }

    @Test
    void evaluateSimpleDivision() {
        Calculator calc = newCalculator();
        assertEquals(5, calc.evaluatePostfix("20 4 /"));
    }

    @Test
    void evaluateComplexExpression() {
        Calculator calc = newCalculator();
        assertEquals(270, calc.evaluatePostfix("10 20 + 9 *"));
    }

    // --- end-to-end: infix -> postfix -> evaluate ---

    @Test
    void endToEnd_withArrayList() {
        Calculator calc = new Calculator(new StackArrayList<>());
        String postfix = calc.infixToPostfix("(10+20)*9");
        Calculator eval = new Calculator(new StackArrayList<>());
        assertEquals(270, eval.evaluatePostfix(postfix));
    }

    @Test
    void endToEnd_withVector() {
        Calculator calc = new Calculator(new StackVector<>());
        String postfix = calc.infixToPostfix("(10+20)*9");
        Calculator eval = new Calculator(new StackVector<>());
        assertEquals(270, eval.evaluatePostfix(postfix));
    }

    @Test
    void endToEnd_withSimpleLinkedList() {
        Calculator calc = new Calculator(new StackList<>(new SimpleLinkedList<>()));
        String postfix = calc.infixToPostfix("(10+20)*9");
        Calculator eval = new Calculator(new StackList<>(new SimpleLinkedList<>()));
        assertEquals(270, eval.evaluatePostfix(postfix));
    }

    @Test
    void endToEnd_withDoublyLinkedList() {
        Calculator calc = new Calculator(new StackList<>(new DoublyLinkedList<>()));
        String postfix = calc.infixToPostfix("(10+20)*9");
        Calculator eval = new Calculator(new StackList<>(new DoublyLinkedList<>()));
        assertEquals(270, eval.evaluatePostfix(postfix));
    }

    @Test
    void endToEnd_complexExpression() {
        Calculator calc = new Calculator(new StackArrayList<>());
        String postfix = calc.infixToPostfix("3+4*2");
        Calculator eval = new Calculator(new StackArrayList<>());
        assertEquals(11, eval.evaluatePostfix(postfix));
    }
}
