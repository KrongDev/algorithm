package com.krong.sort;

public class SelectionSort extends Sort{

    /**
     * 시간복잡도
     * worst: O(n^2)
     * average: O(n^2)
     * best: O(n^2)
     * @param arr int[]
     */
    @Override
    void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(arr, i, min);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        SelectionSort sort = new SelectionSort();
        sort.sort(arr);

        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
