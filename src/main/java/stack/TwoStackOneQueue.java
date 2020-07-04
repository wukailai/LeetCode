package stack;

import java.util.Stack;

/**
 * 两个堆栈实现一个队列
 */

public class TwoStackOneQueue {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.put(1);
        queue.put(2);
        queue.take();
        queue.put(3);
        queue.put(4);
        queue.put(5);
        queue.put(6);
        while (!queue.isEmpty()) {
            System.out.println(queue.take());
        }
    }
}

class Queue {
    Stack<Integer> in = new Stack();
    Stack<Integer> out = new Stack();

    public int take() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public void put(int i) {
        in.push(i);
    }

    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }
}