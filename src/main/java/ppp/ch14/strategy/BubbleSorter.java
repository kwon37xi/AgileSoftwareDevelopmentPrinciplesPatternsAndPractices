package ppp.ch14.strategy;

import java.util.Arrays;

/**
 * Strategy Pattern을 이용한 Bubble Sorter
 */
public class BubbleSorter {
    private int operations = 0;
    private int length = 0;
    private SortHandle itsSortHandle = null;

    public BubbleSorter(SortHandle handle) {
        itsSortHandle = handle;
    }

    public int sort(Object array) {
        itsSortHandle.setArray(array);
        length = itsSortHandle.length();
        operations = 0;

        if (length <= 1)
            return operations;

        for (int nextToLast = length - 2; nextToLast >= 0; nextToLast--)
            for (int index = 0; index <= nextToLast; index++) {
                if (itsSortHandle.outOfOrder(index))
                    itsSortHandle.swap(index);
                operations++;
            }
        return operations;
    }

    public static void main(String[] args) {
        int[] ints = { 8, 2, 4, 6, 1, 3, 10, 7, 5, 9 };
        final BubbleSorter bubbleSorter = new BubbleSorter(new IntSortHandle());
        bubbleSorter.sort(ints);
        System.out.printf("sorted with strategy ints : %s, operations: %d%n", Arrays.toString(ints), bubbleSorter.operations);
    }
}
