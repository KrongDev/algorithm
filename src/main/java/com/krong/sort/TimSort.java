package com.krong.sort;

public class TimSort extends Sort{

    @Override
    void sort(int[] arr) {

    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 2, 5, 3, 7, 4, 6, 8};
        TimSort timSort = new TimSort();
        timSort.sort(arr);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}
