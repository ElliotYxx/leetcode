
/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * 
 * Given a string s, return the longest
 * palindromic
 * 
 * substring
 * in s.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 * 
 * Input: s = "cbbd"
 * Output: "bb"
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
class LongestPalindrome {
    

    /**
     * dp[i][j]表示字符串下标i-j是否回文
     * 时间空间复杂度都为O(n^2)
     * 
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        // 记录最长长度
        int maxLen = 1;
        // 记录开始下标
        int start = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        

        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < s.length(); i++) {
                // 如果不相等 直接false
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    // 考虑边界情况 当字符串长度为3时，左右边界相等的时候，默认回文
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
