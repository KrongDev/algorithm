package com.krong.sort;

public class HeapSort extends Sort{

    /**
     * 시간복잡도
     * worst: O(nlog n)
     * average: O(nlog n)
     * best: O(nlog n)
     * @param arr int[]
     */
    @Override
     void sort(int[] arr) {
        sort(arr, arr.length);
    }

     void sort(int[] a, int size) {
        int parentIdx = getParent(size - 1);
        // max heap
        for(int i = parentIdx; i >= 0; i--) {
            heapify(a, i, size - 1);
        }
        for(int i = size - 1; i > 0; i--) {
            swap(a, 0, i);
            heapify(a, 0, i - 1);
        }

    }

    int getParent(int child) {
        return (child - 1) / 2;
    }


     void heapify(int[] a, int parentIdx, int lastIdx) {
        int leftChildIdx;
        int rightChildIdx;
        int largestIdx;

        while((parentIdx * 2) + 1 <= lastIdx) {
            leftChildIdx = (parentIdx * 2) + 1;
            rightChildIdx = (parentIdx * 2) + 2;
            largestIdx = parentIdx;


            if (a[leftChildIdx] > a[largestIdx]) {
                largestIdx = leftChildIdx;
            }

            if (rightChildIdx <= lastIdx && a[rightChildIdx] > a[largestIdx]) {
                largestIdx = rightChildIdx;
            }

            if (largestIdx != parentIdx) {
                swap(a, parentIdx, largestIdx);
                parentIdx = largestIdx;
            }
            else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,6,7,5,4,8,9};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}
