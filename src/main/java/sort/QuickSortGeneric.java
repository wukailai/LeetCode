package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 快排-范型实现
 */

public class QuickSortGeneric {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(3);
        list.add(1);
        list.add(2);
        quickSort(list, 0, list.size() - 1);
        System.out.println(list);

        Character[] cArray = new Character[] {'c', 'a', 'a', 'd', 'b'};
        System.out.println(Arrays.toString(cArray));
        quickSort2(cArray);
        System.out.println(Arrays.toString(cArray));
    }

    private static <T extends Comparable> void quickSort(List<T> list, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && list.get(j).compareTo(list.get(0)) >= 0) {
                j--;
            }
            while (i < j && list.get(i).compareTo(list.get(0)) <= 0) {
                i++;
            }
            Collections.swap(list, i, j);
        }
        Collections.swap(list, 0, i);
        if (i - 1 > start) {
          quickSort(list, start, i - 1);
        }
        if (i + 1 < end) {
            quickSort(list, i + 1, end);
        }
    }

    private static <T extends Comparable> void quickSort2(T[] a) {
        Stack<Integer> stack = new Stack();
        stack.push(0);
        stack.push(a.length - 1);
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int i = stack.pop();
            int index = getIndex(a, i, j);
            if (i < index - 1) {
                stack.push(i);
                stack.push(index - 1);
            }
            if (index + 1 < j) {
                stack.push(index + 1);
                stack.push(j);
            }
        }
    }

    private static <T extends Comparable> int getIndex(T[] a, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && a[j].compareTo(a[start]) >= 0) {
                j--;
            }
            while (i <j && a[i].compareTo(a[start]) <= 0) {
                i++;
            }
            swap(a, i, j);
        }
        swap(a, start, i);
        return i;
    }

    private static <T extends Comparable> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}