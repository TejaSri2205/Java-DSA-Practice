//Problem : Longest Common Prefix
//Appraoch : Horizontal Scanning for optimal Solution
//Time Complexity : O(N * M) (but faster in practice due to shrinking prefix)
//Space Complexity : O(1)

/*
Idea :
-Start with prefix = first string.
-Compare it with each string and shrink it until it matches.
-Efficient because prefix keeps reducing.
*/

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // Keep shrinking prefix until it matches the start of current string
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] input = {"flower", "flow", "flight"};

        String result = longestCommonPrefix(input);

        System.out.println("Longest Common Prefix: " + result);
    }
}
