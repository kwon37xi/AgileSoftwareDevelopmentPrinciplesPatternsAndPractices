package ppp.ch14.templatemethod;

import java.util.Arrays;

public class DoubleBubbleSorter extends BubbleSorter {
    private double[] array = null;

    public int sort(double[] theArray) {
        array = theArray;
        length = array.length;
        return doSort();
    }

    @Override
    protected void swap(int index) {
        double temp = array[index];
        array[index] = array[index + 1];
        array[index + 1] = temp;
    }

    @Override
    protected boolean outOfOrder(int index) {
        return (array[index] > array[index + 1]);
    }

    public static void main(String[] args) {
        double[] doubles = { 8.0, 2.0, 4.0, 6.0, 1.5, 3.3, 10.1, 7.7, 5.9, 9.2 };
        (new DoubleBubbleSorter()).sort(doubles);
        System.out.println("Soreted doubles : " + Arrays.toString(doubles));
    }
}
