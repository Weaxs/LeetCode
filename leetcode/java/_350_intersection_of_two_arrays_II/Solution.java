package _350_intersection_of_two_arrays_II;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.function.IntFunction;

/**
 *  两个数组的交集 II
 *
 *  给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 *
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 */
public class Solution {

    /**
     * 哈希表
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num:nums1) {
            Integer value = map.getOrDefault(num, 0) + 1;
            map.put(num, value);
        }

//        Set<Integer> ans = new HashSet<>();
        int[] ans = new int[nums1.length];
        int index = 0;
        for (int num:nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
//                ans.add(num);
                ans[index++] = num;
                map.put(num, --count);
            }
        }

        return Arrays.copyOfRange(ans, 0 ,index);

    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        Solution solution = new Solution();
        System.out.println(JSON.toJSONString(solution.intersect(nums1, nums2)));
    }

}
