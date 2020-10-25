//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。
//
//
//
//
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
//
//
// 示例：
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Class3$maxArea {

    // 1. 两层循环，获取每两个柱子之间的容纳量，获取最大值
    /*public int maxArea(int[] height) {
        int max = 0;
        // i循环没有必要获取最后一个数字，因为是求两个不通位置数字
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(max, area);
            }
        }
        return max;
    }*/

    // 2,两个下标，找中间的最大值
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            // 谁短就取谁，取完往内部收敛
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            // 上一句已经进行了i/j的移位，这里要加回去算大小
            int area = (j - i + 1) * minHeight;
            max = Math.max(max, area);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
