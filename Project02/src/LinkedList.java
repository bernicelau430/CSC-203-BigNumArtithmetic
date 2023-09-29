public class LinkedList {
    private Node head;
    private class Node {
        int data;
        Node next;
    }

    public LinkedList (String str) {
        Node curr = null;
        Node prev = null;
        for (int i = 0; i < str.length(); i++) {
            char digit = str.charAt(i);
            int value = digit - '0';

            // Ignore leading 0's
            if (value == 0 && curr == null) {
                continue;
            }
            if (value >= 0 && value <= 9) {
                curr = new Node();
                curr.data = value;
                if (prev != null) {
                    curr.next = prev;
                }
                prev = curr;
            }
        }
        head = curr;
        if (head == null) {
            head = new Node();
            head.data = 0;
        }
    }

    public LinkedList add(LinkedList other) {
        LinkedList result = new LinkedList("");

        Node curr1 = this.head;
        Node curr2 = other.head;
        Node curr_result = result.head;

        int carry = 0;
        while (curr1 != null || curr2 != null) {
            int digit1 = (curr1 != null) ? curr1.data : 0;
            int digit2 = (curr2 != null) ? curr2.data : 0;
            int sum = digit1 + digit2 + carry;

            curr_result.next = new Node();
            curr_result = curr_result.next;
            curr_result.data = sum % 10;
            carry = sum / 10;

            if (curr1 != null) {
                curr1 = curr1.next;
            }
            if (curr2 != null) {
                curr2 = curr2.next;
            }
        }

        // Handle any remaining digits in the longer input number
        if (carry != 0) {
            curr_result.next = new Node();
            curr_result.next.data = carry;
        }

        result.head = result.head.next;
        return result;
    }

    public LinkedList multiply(LinkedList other) {
        // For every digit in this
        LinkedList total = new LinkedList("0");
        Node curr = head;
        int shift_amt = 0;
        while (curr != null) {
            // Multiply that digit with other
            LinkedList sub_product = other.multiply(curr.data);

            // Shift the correct number of times
            for (int i = 0; i < shift_amt; i++) {
                Node newNode = new Node();
                newNode.data = 0;
                newNode.next = sub_product.head;
                sub_product.head = newNode;
            }

            // Add to running total
            total = sub_product.add(total);

            curr = curr.next;
            shift_amt++;
        }
        return total;
    }

    private LinkedList multiply(int num) {
        LinkedList result = new LinkedList("");
        if (num == 0) {
            return result;
        }

        Node curr = this.head;
        Node curr_result = result.head;

        int carry = 0;
        while (curr != null) {
            int mult = curr.data * num + carry;

            curr_result.next = new Node();
            curr_result = curr_result.next;
            curr_result.data = mult % 10;
            carry = mult / 10;

            curr = curr.next;
        }

        // Handle any remaining digits in the longer input number
        if (carry != 0) {
            curr_result.next = new Node();
            curr_result.next.data = carry;
        }

        result.head = result.head.next;
        return result;
    }

    public LinkedList exponentiate(LinkedList other) {
        return this.exponentiate(other.toInt());
    }

    public LinkedList exponentiate(int exponent) {
        if (exponent == 0) {
            return new LinkedList("1");
        }
        if (exponent == 1) {
            return this;
        }
        LinkedList tempResult = this.exponentiate(exponent / 2);
        LinkedList result = tempResult.multiply(tempResult);

        if (exponent % 2 == 1) {
            result = result.multiply(this);
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.insert(0, current.data);
            current = current.next;
        }
        return sb.toString();
    }

    public int toInt() {
        int value = 0;
        int place_value = 1;
        Node current = head;

        // Accumulate decimal place values for each digit in the list
        while (current != null) {
            value += current.data * place_value;
            place_value *= 10;
            current = current.next;
        }

        return value;
    }


}
