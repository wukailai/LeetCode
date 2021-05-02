package stack;

import java.util.Stack;

/**
 * @author wukailai
 * @date 2020/07/05 16:09
 * @description 最小栈
 */

public class MinStack<T extends Comparable> {
    private Stack<T> stack = new Stack();
    private Stack<T> min = new Stack();

    public static void main(String[] args) {
        MinStack<Integer> stack = new MinStack();
        System.out.println(stack.pop());
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        stack.push(-3);
        stack.pop();
        System.out.println(stack.getMin());
        System.out.println(stack.getMin());
    }

    private void push(T t) {
        if (min.isEmpty() || t.compareTo(min.peek()) <= 0) {
            min.push(t);
        }
        stack.push(t);
    }

    private T pop() {
        if (stack.isEmpty()) {
            return null;
        }
        if (min.peek().compareTo(stack.peek()) == 0) {
            min.pop();
        }
        return stack.pop();
    }

    private T getMin() {
        if (stack.isEmpty()) {
            return null;
        }
        return min.peek();
    }
}