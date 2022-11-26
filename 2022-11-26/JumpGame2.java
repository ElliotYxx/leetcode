
// https://leetcode.com/problems/jump-game-ii/
/**
 * You are given a 0-indexed array of integers nums of length n. You are
 * initially positioned at nums[0].
 * 
 * Each element nums[i] represents the maximum length of a forward jump from
 * index i. In other words, if you are at nums[i], you can jump to any nums[i +
 * j] where:
 * 
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are
 * generated such that you can reach nums[n - 1].
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1
 * step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * 
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 */

class solution {
    public static int jump(int[] nums) {
        // 结果
        int res = 0;
        // 每次跳跃的最右边界
        int right = 0;
        // 当前能走到的最远位置
        int maxPos = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 更新当前能走到的最远位置
            maxPos = Math.max(maxPos, nums[i] + i);
            // 如果已经到达上次可到达的右边界
            if (i == right) {
                // 增加一次跳跃
                res++;
                // 更新右边界
                right = maxPos;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 1, 1, 4 };
        System.out.println(jump(arr));
    }
}