package ppp.ch14.strategy;

/** Sort Strategy */
public interface SortHandle {
    void swap(int index);
    boolean outOfOrder(int index);
    int length();
    void setArray(Object array);
}
