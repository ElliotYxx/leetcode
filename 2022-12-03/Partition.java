import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome. Return all possible palindrome partitioning of s.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 * 
 * Input: s = "a"
 * Output: [["a"]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 * Accepted
 * 545,077
 * Submissions
 * 870,197
 */
class Partition {

    public static List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        List<List<String>> res = new ArrayList<>();
        process(s, new ArrayList<>(), res);
        return res;
    }

    public static void process(String s, List<String> step, List<List<String>> res){        // Base case
        if(s == null || s.length() == 0) {
            res.add(new ArrayList<>(step));
            return;
        }
        for(int i = 1; i <= s.length(); i++) {
            String temp = s.substring(0, i);
            if(!isPalindrome(temp)) continue; // only do backtracking when current string is palindrome
            
            step.add(temp);  // choose
            process(s.substring(i, s.length()), step, res); // explore
            step.remove(step.size() - 1); // unchoose
        }
        return;
    }


    /**
     * 判断是否回文
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        int lo = 0;
        int hi = s.length() - 1;
        while (lo <= hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }

    public static void main(String[] args) {
        
    }
    
}
