//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Class3$moveZeroes {
    // 1 两层循环
    /*public void moveZeroes(int[] nums) {
        long zeroNumSize = Arrays.stream(nums).filter(num -> num == 0).count();
        long size = 0;
        for (int i = 0; i < nums.length;) {
            if (nums[i] == 0) {
                if (size++ >= zeroNumSize) {
                    break;
                }
                // 移动到最后,后面的左移
                for (int j = i + 1; j < nums.length; j++) {
                    nums[j - 1] = nums[j];
                }
                nums[nums.length - 1] = 0;
                continue;
            }
            i++;
        }
    }*/

    // 2 新建数组，非0在前，0在后，依次放入
    /*public void moveZeroes(int[] nums) {
        int[] elements = new int[nums.length];
        int start = 0;
        int end = elements.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                elements[start++] = nums[i];
            } else {
                elements[end--] = nums[i];
            }
        }
    }*/

    // 3 单循环，使用j记录非0数字所在位置
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
