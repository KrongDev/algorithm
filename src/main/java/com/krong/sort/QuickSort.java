package com.krong.sort;

public class QuickSort extends Sort{

    /**
     * 시간복잡도
     * worst: O(n^2)
     * average: O(nlog n)
     * best: O(nlog n)
     * @param arr int[]
     */
    @Override
    void sort(int[] arr) {
        m_pivot_sort(arr,0,arr.length-1);
    }

    //=========================== pivot sort ================================

    void l_pivot_sort(int[] arr, int lo, int hi) {
        if(lo >= hi) return;
        int pivot = partition(arr, lo, hi);
        l_pivot_sort(arr, lo, pivot - 1);
        l_pivot_sort(arr, pivot + 1, hi);
    }

    void r_pivot_sort(int[] arr, int lo, int hi) {
        if(lo >= hi) return;
        int pivot = rightPartition(arr, lo, hi);
        r_pivot_sort(arr, lo, pivot - 1);
        r_pivot_sort(arr, pivot + 1, hi);
    }

    void m_pivot_sort(int[] arr, int lo, int hi) {
        if(lo >= hi) return;
        int pivot = middlePartition(arr, lo, hi);
        m_pivot_sort(arr, lo, pivot - 1);
        m_pivot_sort(arr, pivot + 1, hi);
    }

    //=========================== partition ================================

    int partition(int[] arr, int left, int right) {
        int lo = left;
        int hi = right;
        int pivot = arr[lo];
        while (lo < hi) {
            while (lo < hi && arr[hi] > pivot) hi--;
            while (lo < hi && arr[lo] <= pivot) lo++;
            swap(arr, lo, hi);
        }
        swap(arr, left, lo);
        return lo;
    }

    int rightPartition(int[] arr, int left, int right) {
        int lo = left;
        int hi = right;
        int pivot = arr[hi];
        while (lo < hi) {
            while (lo < hi && arr[lo] < pivot) lo++;
            while (lo < hi && arr[hi] >= pivot) hi--;
            swap(arr, lo, hi);
        }
        swap(arr, right, hi);
        return hi;
    }

    int middlePartition(int[] arr, int left, int right) {
        //
        int lo = left - 1;
        int hi = right + 1;
        int pivot = arr[(left + right)/2];
        while (true) {
            do {
                lo++;
            } while (arr[lo] < pivot);
            do {
                hi--;
            } while (arr[hi] > pivot && lo <= hi);
            if (lo >= hi) {
                return hi;
            }
            swap(arr, lo, hi);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 6, 4, 3, 2, 1};

        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);

        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
