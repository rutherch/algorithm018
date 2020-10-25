//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Class3$climbStairs {
    // 1.fibonacci 递归
    /*public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }*/

    // 2.fibonacci 循环
    /*public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }*/

    // 3.滚动数组
    public int climbStairs(int n) {
        int q = 0, p = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            q = p;
            p = r;
            r = q + p;
        }
        return r;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
