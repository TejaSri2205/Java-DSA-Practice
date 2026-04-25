//Problem : Merge Intervals
//Approach : Sorting + Greedy
//Time Complexity: O(n log n) → sorting dominates
//Space Complexity: O(n) → result list

import java.util.*;

public class MergeIntervals {
    
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort intervals based on starting time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();

        int[] current = intervals[0];
        result.add(current);

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            // If overlapping, merge
            if (next[0] <= current[1]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                // No overlap, move to next interval
                current = next;
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
        };

        int[][] merged = merge(intervals);

        System.out.println("Merged Intervals:");
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }
}

/*
Core Idea :
  1.Sort the intervals by start time
    -This ensures that overlapping intervals come next to each other
  2.Greedily merge intervals
  -Maintain a current interval
  -For each next interval:
    -If it overlaps → merge
    -If not → push current and move forward
*/
