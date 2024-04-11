package com.krong.sort;


public class ShellSort extends Sort{

    /**
     * 시간복잡도
     * worst: O(n^2)
     * average: O(n^1.5)
     * best: O(n)
     * @param arr int[]
     */
    @Override
    void sort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j >= gap; j -= gap) {
                    int index = j - gap;
                    if (arr[j] < arr[index]) {
                        swap(arr, j, index);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 6, 4, 3, 2, 1};
        ShellSort shellSort = new ShellSort();
        shellSort.sort(arr);

        for (int j : arr) {
            System.out.print(j + " ");
        }

    }
}
