class Solution:
    def myPow(self, x: float, n: int) -> float:
        # n如果是负数
        if n < 0 :
            x = 1 / x
            n = -n
        return self.fastPow(x, n)

    def fastPow(self, x: float, n: int):
        # any number pow 0 is 1
        if n == 0:
            return 1
        half = self.fastPow(x, n // 2)
        # 偶数
        if n % 2 == 0:
            return half * half
        # 奇数
        else:
            return half * half * x

    def myPow2(self, x: float, n: int) -> float:
        def fastPow(n):
            # any number pow 0 is 1
            if n == 0:
                return 1
            half = fastPow(n // 2)
            return half * half if n % 2 == 0 else half * half * x

        return fastPow(n) if n >= 0 else 1 / fastPow(-n)

    # 官方迭代循环版
    def myPow3(self, x: float, n: int) -> float:
        def quickMul(N):
            ans = 1.0
            # 贡献的初始值为 x
            x_contribute = x
            # 在对 N 进行二进制拆分的同时计算答案
            while N > 0:
                if N % 2 == 1:
                    # 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                    ans *= x_contribute
                # 将贡献不断地平方
                x_contribute *= x_contribute
                # 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
                N //= 2
            return ans

        return quickMul(n) if n >= 0 else 1.0 / quickMul(-n)



solution = Solution()
print(solution.myPow2(2, -4))
