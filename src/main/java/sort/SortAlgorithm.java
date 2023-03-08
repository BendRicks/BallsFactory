package sort;

import util.Comparator;

public interface SortAlgorithm<T> {

    T[] sort(T[] arr, Comparator<T> comparator);

}
