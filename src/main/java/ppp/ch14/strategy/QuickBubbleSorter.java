package ppp.ch14.strategy;

import java.util.Arrays;

public class QuickBubbleSorter {
    private int operations = 0;
    private int length = 0;
    private SortHandle itsSortHandle = null;

    public QuickBubbleSorter(SortHandle sortHandle) {
        itsSortHandle = sortHandle;
    }

    public int sort(Object array) {
        itsSortHandle.setArray(array);
        length = itsSortHandle.length();
        operations = 0;

        if (length <= 1)
            return operations;

        boolean thisPassInOrder = false;
        for (int nextToLast = length - 2; nextToLast >= 0 && !thisPassInOrder; nextToLast--) {
            thisPassInOrder = true;
            for (int index = 0; index <= nextToLast; index++) {
                if (itsSortHandle.outOfOrder(index)) {
                    itsSortHandle.swap(index);
                    thisPassInOrder = false;
                }
                operations++;
            }
        }

        return operations;
    }

    public static void main(String[] args) {
        int[] ints = { 8, 2, 4, 6, 1, 3, 10, 7, 5, 9 };
        final QuickBubbleSorter quickBubbleSorter = new QuickBubbleSorter(new IntSortHandle());
        quickBubbleSorter.sort(ints);
        System.out.printf("quick sorted with strategy ints : %s, operations: %d%n", Arrays.toString(ints), quickBubbleSorter.operations);
    }
}
