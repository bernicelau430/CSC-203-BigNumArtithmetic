import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigNumArithmeticTest {

    // test addition
    @Test
    public void testAddWithTwoSingleDigitNumbers() {
        LinkedList num1 = new LinkedList("5");
        LinkedList num2 = new LinkedList("6");
        int expected = 11;
        assertEquals(expected, num1.add(num2).toInt());
    }

    @Test
    public void testAddWithTwoMultiDigitNumbers() {
        LinkedList num1 = new LinkedList("321");
        LinkedList num2 = new LinkedList("54");
        int expected = 375;
        assertEquals(expected, num1.add(num2).toInt());
    }

    @Test
    public void testAddWithOneNumberEqualToZero() {
        LinkedList num1 = new LinkedList("0");
        LinkedList num2 = new LinkedList("1");
        int expected = 1;
        assertEquals(expected, num1.add(num2).toInt());
    }

    @Test
    public void testAddWithBothNumbersEqualToZero() {
        LinkedList num1 = new LinkedList("0");
        LinkedList num2 = new LinkedList("0");
        int expected = 0;
        assertEquals(expected, num1.add(num2).toInt());
    }

    @Test
    public void testAddWithOneEmptyLinkedList() {
        LinkedList num1 = new LinkedList("");
        LinkedList num2 = new LinkedList("5");
        int expected = 5;
        assertEquals(expected, num1.add(num2).toInt());
    }

    @Test
    public void testAddWithBothEmptyLinkedLists() {
        LinkedList num1 = new LinkedList("");
        LinkedList num2 = new LinkedList("");
        int expected = 0;
        assertEquals(expected, num1.add(num2).toInt());
    }

    // test multiplication
    @Test
    public void testMultiplyByOne() {
        LinkedList num1 = new LinkedList("642");
        LinkedList num2 = new LinkedList("1");
        int expected = 642;
        assertEquals(expected, num1.multiply(num2).toInt());
    }

    @Test
    public void testMultiplyByZero() {
        LinkedList num1 = new LinkedList("321");
        LinkedList num2 = new LinkedList("0");
        int expected = 0;
        assertEquals(expected, num1.multiply(num2).toInt());
    }

    @Test
    public void testMultiplyTwoSingleDigitNumbers() {
        LinkedList num1 = new LinkedList("3");
        LinkedList num2 = new LinkedList("5");
        int expected = 15;
        assertEquals(expected, num1.multiply(num2).toInt());
    }

    @Test
    public void testMultiplyTwoMultipleDigitNumbers() {
        LinkedList num1 = new LinkedList("123");
        LinkedList num2 = new LinkedList("456");
        int expected = 56088;
        assertEquals(expected, num1.multiply(num2).toInt());
    }

    @Test
    public void testMultiplyWithLargeNumbers() {
        LinkedList num1 = new LinkedList("9999");
        LinkedList num2 = new LinkedList("9999");
        int expected = 99980001;
        assertEquals(expected, num1.multiply(num2).toInt());
    }

    // test exponentiation
    @Test
    public void testExponentiate0() {
        LinkedList base = new LinkedList("1");
        int exponent = 0;
        int expected = 1;
        assertEquals(expected, base.exponentiate(exponent).toInt());
    }

    @Test
    public void testExponentiate1() {
        LinkedList base = new LinkedList("2");
        int exponent = 1;
        int expected = 2;
        assertEquals(expected, base.exponentiate(exponent).toInt());
    }

    @Test
    public void testExponentiate2() {
        LinkedList base = new LinkedList("2");
        int exponent = 2;
        int expected = 4;
        assertEquals(expected, base.exponentiate(exponent).toInt());
    }

    @Test
    public void testExponentiate10() {
        LinkedList base = new LinkedList("2");
        int exponent = 10;
        int expected = 1024;
        assertEquals(expected, base.exponentiate(exponent).toInt());
    }

    @Test
    public void testExponentiate4() {
        LinkedList base = new LinkedList("5");
        int exponent = 4;
        int expected = 625;
        assertEquals(expected, base.exponentiate(exponent).toInt());
    }

    @Test
    public void testExponentiateWith0Base() {
        LinkedList base = new LinkedList("0");
        int exponent = 5;
        int expected = 0;
        assertEquals(expected, base.exponentiate(exponent).toInt());
    }
}
