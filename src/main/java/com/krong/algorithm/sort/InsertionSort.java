package com.krong.algorithm.sort;

public class InsertionSort extends Sort{
    /**
     * 시간복잡도
     * worst: O(n^2)
     * average: O(n^2)
     * best: O(n)
     * @param arr
     */
    @Override
    void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 2, 6, 1, 87,2};
        InsertionSort sort = new InsertionSort();
        sort.sort(arr);
        for (int i : arr) {
            System.out.println(i + " ");
        }
    }
}
