package _204_count_primes;

import java.util.ArrayList;
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
            if (isPrime(i)) {
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimes(10));
    }


}
