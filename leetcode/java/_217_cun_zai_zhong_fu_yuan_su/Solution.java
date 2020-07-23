package _217_cun_zai_zhong_fu_yuan_su;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 *  存在重复元素
 *
 *  给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 */
public class Solution {

    // 1. HashSet
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> factor = new HashSet<>();
        for (Integer num:nums) {
            if (factor.contains(num)) {
                return true;
            } else {
                factor.add(num);
            }
        }
        return false;

    }

    // 2. 排序
    public boolean containsDuplicate2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        Arrays.sort(nums);
        int pre = nums[0];
        for (int i = 1;i < nums.length;i++) {
            if (pre == nums[i]) {
                return true;
            } else {
                pre = nums[i];
            }
        }
        return false;
    }

}
