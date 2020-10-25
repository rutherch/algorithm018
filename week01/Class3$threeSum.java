//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例：
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
//
// Related Topics 数组 双指针


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Class3$threeSum {

    // 1.三层循环
    /*public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new LinkedHashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if ((nums[i] + nums[j] + nums[k]) == 0) {
                        List<Integer> result = Arrays.asList(nums[i], nums[j], nums[k]);
                        result.sort(Comparator.naturalOrder());
                        set.add(result);
                    }
                }
            }
        }
        return new ArrayList(set);
    }*/

    // 2.hash 两层循环
    /*public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new LinkedHashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(0 - nums[i], i);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Integer temp = map.get(nums[i] + nums[j]);
                if (temp != null && temp > i && temp > j) {
                    List<Integer> result = Arrays.asList(nums[i], nums[j], 0 - nums[i] - nums[j]);
                    result.sort(Comparator.naturalOrder());
                    set.add(result);
                }
            }
        }
        return new ArrayList(set);
    }*/

    // 3.排序夹逼
    /*public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1, k = nums.length - 1; j < k;) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }
                int temp = nums[i] + nums[j] + nums[k];
                if (temp == 0) {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (temp < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return list;
    }*/

    // 4.更简洁
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    while (j < k && nums[j] == nums[++j]);
                } else if (sum > 0) {
                    while (j < k && nums[k] == nums[--k]);
                } else {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[++j]);
                    while (j < k && nums[k] == nums[--k]);
                }
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
