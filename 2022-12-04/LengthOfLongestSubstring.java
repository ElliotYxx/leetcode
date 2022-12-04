import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * 
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * 
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a
 * substring.
 * 
 * 
 * Constraints:
 * 
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 结果
        int ans = 1;

        int lo = 0;
        int hi = 1;
        // 存储各个字符所在的位置
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(lo), 0);
        while (hi < s.length()) {

            Integer index = map.get(s.charAt(hi));
            if (index != null && index >= lo) {
                // 如果字符上一次出现的位置在窗口外，则不需要更新; 如果在窗口内 则需要更新左边界
                lo = index + 1;
            }

            map.put(s.charAt(hi), hi);
            ans = Math.max(ans, hi - lo + 1);
            hi++;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
