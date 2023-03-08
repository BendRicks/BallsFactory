package util;

import sort.SortAlgorithm;

import java.lang.reflect.Array;
import java.util.*;

public class MultiThreadSorter<T> {

    private final Class<T> clazz;
    private Comparator<T> comparator;

    public MultiThreadSorter(Class<T> clazz, Comparator<T> comparator) {
        this.clazz = clazz;
        this.comparator = comparator;
    }

    public void setComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    /**
     * Sorts array multithread with provided comparator. Method splits array and sorts all parts in multiple threads.
     *
     * @param arr         Array to sort
     * @param threadsAmount Amount of parts which array will be split to
     */
    public T[] sortArrMultiThread(T[] arr, SortAlgorithm<T> algorithm, int threadsAmount) {
        int arrPartLength = arr.length / threadsAmount;
        if (arr.length % threadsAmount != 0) {
            arrPartLength++;
        }
        ArrayDeque<T[]> arrays = new ArrayDeque<>();
        int lengthLeft = arr.length;
        while (lengthLeft > 0) {
            int startIndex = arr.length - lengthLeft;
            int endIndex = lengthLeft > arrPartLength
                    ? startIndex + arrPartLength
                    : arr.length;
            arrays.push(Arrays.copyOfRange(arr, startIndex, endIndex));
            lengthLeft -= arrPartLength;
        }
        List<Thread> threads = new ArrayList<>();
        for (T[] array : arrays) {
            Thread sortThread = new Thread(() -> {
                algorithm.sort(array, comparator);
            });
            threads.add(sortThread);
            sortThread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threads.clear();
        while (arrays.size() >= 2) {
            T[] array1 = arrays.pop();
            T[] array2 = arrays.pop();
            Thread mergeThread = new Thread(() -> {
                arrays.push(sortMergeArrays(array1, array2));
            });
            threads.add(mergeThread);
            mergeThread.start();
            if (arrays.size() < 2) {
                for (Thread thread : threads) {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                threads.clear();
            }
        }
        return arrays.pop();
    }

    public T[] sortMergeArrays(T[] arr1, T[] arr2) {
        T[] result = createArray(arr1.length + arr2.length);
        int counter = arr1.length + arr2.length - 1;
        int index1 = arr1.length - 1;
        int index2 = arr2.length - 1;
        while (counter >= 0) {
            if (index1 < 0
                    || (index2 >= 0 && comparator.compare(arr1[index1], arr2[index2]) > 0)) {
                result[counter] = arr2[index2];
                index2--;
            } else {
                result[counter] = arr1[index1];
                index1--;
            }
            counter--;
        }
        return result;
    }

    private T[] createArray(int size) {
        return (T[]) Array.newInstance(clazz, size);
    }

}

