import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/count-of-smaller-numbers-after-self/
/**
 * Given an integer array nums, return an integer array counts where counts[i]
 * is the number of smaller elements to the right of nums[i].
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * Example 2:
 * 
 * Input: nums = [-1]
 * Output: [0]
 * Example 3:
 * 
 * Input: nums = [-1,-1]
 * Output: [0,0]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class CountSmaller {
    /**
     * 时间复杂度过高 O(n^2)
     * 
     * @param nums
     * @return
     */
    public static List<Integer> countSmaller1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        // 两个for遍历比当前数小的值
        for (int i = 0; i < nums.length - 1; i++) {
            int curr = nums[i];
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (curr > nums[j]) {
                    count++;
                }
            }
            res.add(count);
        }
        // 最后加个0
        res.add(0);
        return res;
    }

    public static void main(String[] args) {

    }

}
