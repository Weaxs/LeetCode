package java._172_factorialTrailingZeroes;

/**
 * 阶乘后的零
 *
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 */
public class Solution {

    /**
     * 通过检查5的个数包括25中的5来计算有多少个零
     * 5*任何一个偶数 就能出现一个0
     * 但时间太长 O(n)
     */
    public int trailingZeroes(int n) {
        int zeroCount = 0;
        for (int i = 5; i <=n;i +=5 ) {
            int fiveFactorCount = i;
            while (fiveFactorCount % 5 ==0) {
                zeroCount++;
                fiveFactorCount /= 5;
            }
        }
        return zeroCount;
    }

    /**
     *
     * 时间复杂度 O(log n)
     */
    public int trailingZeroes2(int n) {
        int zeroCount = 0;
        long powerFive = 5;
        while (n >= powerFive) {
            zeroCount += (n / powerFive);
            powerFive *= 5;
        }
        return zeroCount;
//        int zeroCount = 0;
//        long currentMultiple = 5;
//        while (n > 0) {
//            n /= 5;
//            zeroCount += n;
//        }
//        return zeroCount;

    }

    public static void main(String[] args) {

    }

}
