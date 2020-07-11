package _202_happy_number;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 *
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为1，那么这个数就是快乐数。
 *
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 *
 * 示例：
 * 输入：19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 */
public class Solution {

    /**
     * 对于非快乐树，不断循环会形成环状  例如：116  38  73  58  89  145  42  20  4  16  37  58
     * 对于快乐树，不会形成环  例如： 7  49  97  130  10 1
     * 所以用一个Set保存已有的数字，当数字存在于set中，则出现环状，不为快乐树
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            int sum = 0;
            //计算当前数字每个位置上的平方和
            while (n > 0) {
                int d = n % 10;
                n /= 10;
                sum += d * d;
            }
            n = sum;
        }
        return n == 1;
    }

    /**
     * 我们知道任何循环都必须包含小于 243 的数字 (81 + 81 + 81) 999
     * 如果这样做，您会发现只有一个循环：4 \rightarrow 16 \rightarrow 37 \rightarrow 58 \rightarrow 89 \rightarrow 145 \rightarrow 42 \rightarrow 20 \rightarrow 44→16→37→58→89→145→42→20→4。所有其他数字都在进入这个循环的链上，或者在进入 11 的链上。
     * 我们可以硬编码一个包含这些数字的散列集，如果我们达到其中一个数字，那么我们就知道在循环中。
     */
    private static Set<Integer> cycleMembers =
            new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));

    public boolean isHappy2(int n) {
        while (n != 1 && !cycleMembers.contains(n)) {
            int totalSum = 0;
            while (n > 0) {
                int d = n % 10;
                n /= 10;
                totalSum += d * d;
            }
            n = totalSum;
        }
        return n == 1;
    }

    // 计算当前数字每个位置上的平方和
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(19));
    }

}
