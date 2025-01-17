package com.krong.twoPointer;

import java.util.Arrays;

public class TwoPointer {

    public int[] solution(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int target = 6;
        TwoPointer twoPointer = new TwoPointer();
        System.out.println(Arrays.toString(twoPointer.solution(nums, target)));
    }
}
