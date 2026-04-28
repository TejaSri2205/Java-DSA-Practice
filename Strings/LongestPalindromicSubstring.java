//Problem :  Longest Palindromic Substring
//Approach : Manacher’s Algorithm for optimal solution
// Time Complexity: O(n)
// Space Complexity: O(1)

/*
Idea :
This is the true optimal solution:
  -Transform string to avoid even/odd handling:
      Example: "abba" → "#a#b#b#a#"
  -Use symmetry to reuse previous results
  -Maintain:
      center
      right boundary
      palindrome radius array
*/

import java.util.*;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String result = longestPalindrome(input);
        System.out.println("Longest Palindromic Substring: " + result);

        sc.close();
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        // Step 1: Transform string
        String t = preprocess(s);
        int n = t.length();
        int[] p = new int[n];

        int center = 0, right = 0;
        int maxLen = 0, centerIndex = 0;

        // Step 2: Manacher's logic
        for (int i = 0; i < n; i++) {
            int mirror = 2 * center - i;

            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // Expand around center i
            int a = i + (1 + p[i]);
            int b = i - (1 + p[i]);

            while (a < n && b >= 0 && t.charAt(a) == t.charAt(b)) {
                p[i]++;
                a++;
                b--;
            }

            // Update center and right boundary
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            // Track max palindrome
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        // Step 3: Extract result
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }

    // Helper to insert separators (#)
    private static String preprocess(String s) {
        StringBuilder sb = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            sb.append(c).append("#");
        }
        return sb.toString();
    }
}
