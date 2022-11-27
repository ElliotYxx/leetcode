
import java.lang.Character;

// https://leetcode.com/problems/reverse-only-letters/
/**
 * Given a string s, reverse the string according to the following rules:
 * 
 * All the characters that are not English letters remain in the same position.
 * All the English letters (lowercase or uppercase) should be reversed.
 * Return s after reversing it.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "ab-cd"
 * Output: "dc-ba"
 * Example 2:
 * 
 * Input: s = "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * Example 3:
 * 
 * Input: s = "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 100
 * s consists of characters with ASCII values in the range [33, 122].
 * s does not contain '\"' or '\\'.
 */

class ReverseOnlyLetters {
    public static String reverseOnlyLetters(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0;
        int end = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);
        int count = 1;

        // 双指针
        while (start < end) {
            while (!Character.isLetter(s.charAt(start)) && start < end) {
                start++;
            }
            while (!Character.isLetter(s.charAt(end)) && end > start) {
                end--;
            }
            sb.setCharAt(start, s.charAt(end));
            sb.setCharAt(end, s.charAt(start));
            start++;
            end--;
            System.out.println("第" + count + "次交换：" + sb.toString());
            count++;

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        reverseOnlyLetters("7_28]");
    }
}