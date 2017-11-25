package ppp.ch14.templatemethod;

import java.util.Arrays;

public class IntBubbleSorter extends BubbleSorter {
    private int[] array = null;

    public int sort(int[] theArray) {
        array = theArray;
        length = array.length;
        return doSort();
    }

    @Override
    protected void swap(int index) {
        int temp = array[index];
        array[index] = array[index + 1];
        array[index + 1] = temp;
    }

    @Override
    protected boolean outOfOrder(int index) {
        return (array[index] > array[index + 1]);
    }

    public static void main(String[] args) {
        int[] ints = { 8, 2, 4, 6, 1, 3, 10, 7, 5, 9 };
        (new IntBubbleSorter()).sort(ints);
        System.out.println("Soreted ints : " + Arrays.toString(ints));
    }
}
