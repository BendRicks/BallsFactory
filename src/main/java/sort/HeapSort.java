package sort;

import comparator.Comparator;

public class HeapSort<T> implements SortAlgorithm<T>{

    private Comparator<T> comparator;

    @Override
    public T[] sort(T[] arr, Comparator<T> comparator) {
        this.comparator = comparator;
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        for (int i=n-1; i>=0; i--)
        {
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
        return arr;
    }

    void heapify(T[] arr, int n, int i)
    {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        if (left < n && comparator.compare(arr[left], arr[largest]) < 0)
            largest = left;
        if (right < n && comparator.compare(arr[right], arr[largest]) < 0)
            largest = right;
        if (largest != i)
        {
            T swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

}
