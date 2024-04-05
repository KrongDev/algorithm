package com.krong.sort;

public class BubbleSort extends Sort{
    /**
     * 시간복잡도
     * worst: O(n^2)
     * average: O(n^2)
     * best: O(n^2)
     * @param arr int[]
     */
    @Override
    public void sort(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    swap(arr,i,j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,5,87,4,1};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);
        for(int n:arr){
            System.out.println(n);
        }
    }
}
