import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/
/**
 * Given an integer array nums and an integer k, return the number of pairs (i,
 * j) where i < j such that |nums[i] - nums[j]| == k.
 * 
 * The value of |x| is defined as:
 * 
 * x if x >= 0.
 * -x if x < 0.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,2,1], k = 1
 * Output: 4
 * Explanation: The pairs with an absolute difference of 1 are:
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * Example 2:
 * 
 * Input: nums = [1,3], k = 3
 * Output: 0
 * Explanation: There are no pairs with an absolute difference of 3.
 * Example 3:
 * 
 * Input: nums = [3,2,1,5,4], k = 2
 * Output: 3
 * Explanation: The pairs with an absolute difference of 2 are:
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * 1 <= k <= 99
 */
class CountKDifference {

    /**
     * 双重循环 时间复杂度 O(n^2)
     * 
     * @param nums
     * @param k
     * @return
     */
    public static int countKDifference(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (k == Math.abs(nums[i] - nums[j])) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static int countKDifference2(int[] nums, int k) {
        int ans = 0;
        // 用于记录 下标和出现次数的map
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            ans += map.getOrDefault(k + num, 0) + map.getOrDefault(num - k, 0);

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 2, 1 };
        System.out.println("res:" + countKDifference(nums, 1));
    }
}
