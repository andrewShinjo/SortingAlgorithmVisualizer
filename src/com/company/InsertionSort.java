package com.company;

public class InsertionSort<T extends Comparable<? super T>> {
    private CanvasPanel observer;

    public InsertionSort(CanvasPanel c) {
        observer = c;
    }

    public void notifyObserver() {
        observer.modelChanged();
    }


    public void sort(T[] arr) {
        new Thread(new Runnable() {
            @Override
            public void run() {
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
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
