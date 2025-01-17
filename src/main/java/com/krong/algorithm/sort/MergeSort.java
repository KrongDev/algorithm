package com.krong.algorithm.sort;

public class MergeSort extends Sort{

    int[] slice(int[] origin, int start, int end) {
        int[] result = new int[end-start];

        for(int i = start; i < end; i++){
            result[i-start] = origin[i];
        }

        return result;
    }

    void merge (int[] origin, int[] left, int[] right, int l, int r) {
        int index = 0, lIndex = 0, rIndex = 0;

        while (lIndex < l && rIndex < r) {
            if(left[lIndex] < right[rIndex]){
                origin[index] = left[lIndex++];
            } else {
                origin[index] = right[rIndex++];
            }
            index++;
        }

        while (lIndex < l) {
            origin[index++] = left[lIndex++];
        }
        while (rIndex < r) {
            origin[index++] = right[rIndex++];
        }
    }

    void mergeSort(int[] a, int n) {
        if(n < 2) return;
        int mid = n/2;
        int[] left = slice(a, 0, mid);
        int rightEnd = n - mid;
        int[] right = slice(a, mid, n);

        mergeSort(left, mid);
        mergeSort(right, rightEnd);
        merge(a, left, right, mid, rightEnd);
    }

    /**
     * 시간복잡도
     * worst: O(nlog n)
     * average: O(nlog n)
     * best: O(nlog n)
     * @param arr
     */
    @Override
    void sort(int[] arr) {
        mergeSort(arr, arr.length);
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = new int[]{5,2,4,6,8,1,5,2,34,4};
        mergeSort.sort(arr);

        for(int n : arr) {
            System.out.print(n + " ");
        }
    }
}
