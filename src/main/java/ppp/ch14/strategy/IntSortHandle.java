package ppp.ch14.strategy;

/**
 * Integer sorting strategy
 */
public class IntSortHandle implements SortHandle {
    private int[] array = null;

    @Override
    public void swap(int index) {
        int temp = array[index];
        array[index] = array[index + 1];
        array[index + 1] = temp;
    }

    @Override
    public void setArray(Object array) {
        this.array = (int[]) array;
    }

    @Override
    public int length() {
        return array.length;
    }

    @Override
    public boolean outOfOrder(int index) {
        return (array[index] > array[index + 1]);
    }
}
