package com.krong.cording_test.inflearn.list;

import java.util.Arrays;

public class TwoSum {
    //정수가 저장된 배열 nums이 주어졌을 때, nums의 원소 중 두 숫자를 더해서 target이 될 수 있으면 True, False를 반환하세요. 같은 원소를 두번 사용할 수 없습니다.
    public static void main(String[] args) {
        int[] nums = {4, 1, 9, 7, 5, 3, 16};
        int target = 14;
        nums = Arrays.stream(nums).sorted().toArray();
        System.out.println(twoSum(nums, target));
    }

    public static boolean twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) return true;
            if (sum < target) l++;
            else r--;
        }
        return false;
    }
}
