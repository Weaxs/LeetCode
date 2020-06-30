package java._198_daJiaJieShe;

/**
 * 打家劫舍
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
/**
 * 类似的题目：按摩师
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 注意：本题相对原题稍作改动
 *
 *  
 *
 * 示例 1：
 *
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 * 示例 2：
 *
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 * 示例 3：
 *
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 *
 */
public class Solution {

    /**
     * 动态规划
     * f(k) = 从前 k 个房屋中能抢劫到的最大数额，A_i = 第 i 个房屋的钱数。
     *
     * 首先看 n = 1 的情况，显然 f(1) = A_1。
     *
     * 再看 n = 2，f(2) = max(A_1, A_2)。
     *
     * 对于 n = 3，有两个选项:
     * 抢第三个房子，将数额与第一个房子相加。
     * 不抢第三个房子，保持现有最大数额。
     * 显然，你想选择数额更大的选项。于是，可以总结出公式：
     *
     * f(k) = max(f(k – 2) + A_k, f(k – 1))
     *
     */
    public int rob(int[] nums) {
        int preMaxValue = 0;
        int currMaxValue = 0;
        for (int num:nums) {
            int tmp = currMaxValue;
            currMaxValue = Math.max(preMaxValue + num, currMaxValue);
            preMaxValue = tmp;
        }
        return currMaxValue;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,7,9,3,1};
        System.out.println(solution.rob(nums));
    }


}
