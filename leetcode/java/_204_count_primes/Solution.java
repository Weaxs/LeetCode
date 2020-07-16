package _204_count_primes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 计数质数
 *
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7
 *
 */
public class Solution {

    //
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n ; i++) {
            if (isPrime2(i)) {
                count++;
            }
        }
        return count;
    }

    // 如果是素数，依次除素数集合均不能整除的，就是素数(超时 499979)
    List<Integer> primes = new ArrayList<>();
    private boolean isPrime(int n) {
        for (Integer prime:primes) {
            if (n % prime == 0 && n != 2) {
                return false;
            }
        }
        primes.add(n);
        return true;
    }

    // 在依次对素数整除判断的同时，进行优化
    // 只计算到 n >= 素数*素数 时，例如如果判断173是否是素数，无需把小于173的素数全部整除，只需要整除小于17的素数(17 * 17 =289)即可
    // 因为即便它非素数，他也是17 * 比17小的素数。既然遍历到了17，还没能整除，就可以证明它是素数
    private boolean isPrime2(int n) {
        for (Integer prime:primes) {
            if (prime * prime > n) {
                break;
            } else if (n % prime == 0 && n != 2) {
                return false;
            }
        }
        primes.add(n);
        return true;
    }

    /**
     * 厄拉多塞筛法
     */
    public int countPrimes3(int n) {
        if (n <= 2) {
            return 0;
        }
        // 创建 并 初始化 整个素数数组
        boolean[] primes = new boolean[n];
        primes[0] = false;
        // 划掉0和1
        primes[1] = false;
        //设置上界
        int sqrt = (int)Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (!primes[i]) {
                // 不是素数，可以跳过
                continue;
            }
            // 划掉倍数
            for (int multi = i << 1; multi < n ; multi += i){
                primes[multi] = false;
            }
        }
        int count = 0;
        // 统计数组中素数的数量
        for (boolean prime : primes) {
            if (prime) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimes(1500000));
    }


}
