package com.company;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Sorter<T extends Comparable<? super T>> {
    private CanvasPanel observer;
    ReentrantLock lock = new ReentrantLock();

    public Sorter(CanvasPanel c) {
        observer = c;
    }

    public void notifyObserver() {
        observer.modelChanged();
    }

    public void bubbleSort(T[] arr) {
        lock.lock();
        new Thread(new Runnable() {
            @Override
            public void run() {
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
        }).start();
        lock.unlock();
    }

    public void insertionSort(T[] arr) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
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
                            Thread.sleep(25);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    lock.unlock();
                }

            }
        }).start();
    }

    public void selectionSort(T[] arr) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr.length - 1; i++)
                {
                    int min = i;
                    for (int j = i + 1; j < arr.length; j++)
                    {
                        if (arr[j].compareTo(arr[min]) < 0)
                        {
                            min = j;
                        }
                    }
                    if (min != i)
                    {
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
        }).start();
    }

    public void heapSort(T[] arr) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int size = arr.length;
                for (int i = size / 2 - 1; i >= 0; i--) {
                    heapify(arr, size, i);
                }
                for (int i = size - 1; i >= 0; i--) {
                    T temp = arr[0];
                    arr[0] = arr[i];
                    arr[i] = temp;
                    try {
                        Thread.sleep(25);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    heapify(arr, i, 0);
                }
            }
        }).start();
    }

    private void heapify(T[] array, int size, int i) {
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
        notifyObserver();
        try {
            Thread.sleep(25);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void shuffle(T[] arr) {
        lock.lock();
        try {
            List<T> list = Arrays.asList(arr);
            Collections.shuffle(list);
            list.toArray(arr);
            notifyObserver();
        } finally {
            lock.unlock();
        }
    }
}
