package sort;

import util.Comparator;

public class QuickSort<T> implements SortAlgorithm<T>{

    private Comparator<T> comparator;

    @Override
    public T[] sort(T[] arr, Comparator<T> comparator) {
        this.comparator = comparator;
        sortArrQuick(arr, 0, arr.length-1);
        return arr;
    }

    private void sortArrQuick(T[] arr, int low, int high) {
        if (arr.length == 0 || low >= high) return;
        int middle = low + (high - low) / 2;
        T border = arr[middle];
        int i = low, j = high;
        while (i <= j) {
            while (comparator.compare(arr[i], border) > 0) i++;
            while (comparator.compare(arr[j], border) < 0) j--;
            if (i <= j) {
                T swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap;
                i++;
                j--;
            }
        }
        if (low < j) sortArrQuick(arr, low, j);
        if (high > i) sortArrQuick(arr, i, high);
    }

}
