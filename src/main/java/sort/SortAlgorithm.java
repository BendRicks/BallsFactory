package sort;

import comparator.Comparator;

public interface SortAlgorithm<T> {

    /**
     * Sorts array with provided comparator
     * @param arr Array to sort
     * @param comparator Comparator which will be used
     * @return Sorted array
     */
    T[] sort(T[] arr, Comparator<T> comparator);

}
