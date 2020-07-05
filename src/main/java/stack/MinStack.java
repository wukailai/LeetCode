package stack;

import java.util.Stack;

/**
 * @author wukailai
 * @date 2020/07/05 16:09
 * @description 最小栈
 */
public class MinStack {
    private Stack<Integer> stack = new Stack();
    private Stack<Integer> min = new Stack();

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }

    public void push(int i) {
        if (min.isEmpty() || i < min.peek()) {
            min.push(i);
        }
        stack.push(i);
    }

    public int pop() {
        if (stack.peek() == min.peek()) {
            min.pop();
        }
        return stack.pop();
    }

    public int getMin() {
        return min.peek();
    }
}