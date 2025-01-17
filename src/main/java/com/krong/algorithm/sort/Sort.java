package com.krong.algorithm.sort;

public abstract class Sort {
    //
    void sort(int[] arr){}

    void swap (int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
