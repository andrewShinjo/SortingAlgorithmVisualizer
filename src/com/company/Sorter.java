package com.company;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sorter<T extends Comparable<? super T>> {
    private CanvasPanel observer;

    /** Constructor for Sorter object.
     *
     * @param c = the panel that has the array sorter will work on
     */
    public Sorter(CanvasPanel c) {
        observer = c;
    }

    /** Notifies observer that a change was made to array.
     *
     */
    public void notifyObserver() {
        observer.modelChanged();
    }

    /** Implementation of merge sort.
     *
     * @param arr = the array to sort
     * @param start = the beginning of partition to operate on
     * @param end = the end of partition to operate on
     */
    public synchronized void mergeSort(T[] arr, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(arr, start, middle);
            mergeSort(arr, middle + 1, end);
            merge(arr, start, middle, end);
        }
    }

    /** Implementation of merge sort's helper function, merge.
     *
     * @param arr = the array to sort
     * @param start = the beginning of partition to operate on
     * @param middle = the middle of partition to operate on
     * @param end = the end of partition to operate on
     */
    private void merge(T[] arr, int start, int middle, int end) {
        T[] left = (T[]) new Comparable[middle - start + 1];
        T[] right = (T[]) new Comparable[end - middle];

        for(int i = 0; i < left.length; i++) {
            left[i] = arr[start + i];
        }
        for(int i = 0; i < right.length; i++) {
            right[i] = arr[middle + 1 + i];
        }

        int leftIndex = 0, rightIndex = 0;
        int current = start;

        while(leftIndex < left.length && rightIndex < right.length) {
            if(left[leftIndex].compareTo(right[rightIndex]) <= 0) {
                arr[current] = left[leftIndex];
                leftIndex++;
            } else {
                arr[current] = right[rightIndex];
                rightIndex++;
            }
            current++;
        }
        while(leftIndex < left.length) {
            arr[current++] = left[leftIndex++];
        }
        while(rightIndex < right.length) {
            arr[current++] = right[rightIndex++];
        }
        notifyObserver();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /** Implementation of bubble sort.
     *
     * @param arr = the array to sort
     */
    public synchronized void bubbleSort(T[] arr) {
        int size = arr.length;
        while(size > 0) {
            int last = 0;
            for(int i = 1; i < size; i++) {
                if(arr[i - 1].compareTo(arr[i]) > 0) {
                    T temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    last = i;
                    notifyObserver();
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            size = last;
        }
    }

    /** Implementation of insertion sort.
     *
     * @param arr = the array to sort
     */
    public synchronized void insertionSort(T[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int current = i;

            while(current > 0 && arr[current - 1].compareTo(arr[current]) > 0) {
                T temp = arr[current];
                arr[current] = arr[current - 1];
                arr[current - 1] = temp;
                current--;
            }
            notifyObserver();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /** Implementation of selection sort.
     *
     * @param arr = the array to sort
     */
    public synchronized void selectionSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[min]) < 0) {
                    min = j;
                }
            }
            if (min != i) {
                T temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
            notifyObserver();
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /** Implementation of heap sort.
     *
     * @param arr = the array to sort
     */
    public synchronized void heapSort(T[] arr) {
        int size = arr.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(arr, size, i);
        }
        for (int i = size - 1; i >= 0; i--) {
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    /** Implementation of heap sort's helper function, heapify.
     *
     * @param array = the array to sort
     * @param size = size of heap
     * @param i = location of element to heapify
     */
    private void heapify(T[] array, int size, int i) {
        notifyObserver();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int max = i;
        int left  = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && array[left].compareTo(array[max]) > 0) {
            max = left;
        }
        if (right < size && array[right].compareTo(array[max]) > 0) {
            max = right;
        }
        if (max != i) {
            T temp = array[i];
            array[i] = array[max];
            array[max] = temp;
            heapify(array, size, max);
        }
    }

    /** Randomly shuffles the position of the elements in an array.
     *
     * @param arr = array to randomize
     */
    public synchronized void shuffle(T[] arr) {
        List<T> list = Arrays.asList(arr);
        Collections.shuffle(list);
        list.toArray(arr);
        notifyObserver();
    }
}
