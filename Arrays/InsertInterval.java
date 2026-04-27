//Problem : Insert Interval
//Approach : Greedy + Interval Traversal Pattern
//Time Complexity : O(n)
//Space Complexity : O(n)

import java.util.*;

public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Step 1: Add all intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Step 2: Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Step 3: Add remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        int[][] intervals = {
            {1, 2},
            {3, 5},
            {6, 7},
            {8, 10},
            {12, 16}
        };

        int[] newInterval = {4, 8};

        int[][] result = insert(intervals, newInterval);

        // Print output
        System.out.println("Merged Intervals:");
        for (int[] interval : result) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}

/*
Idea :

Iterate through intervals:
  1.Add all intervals that end before newInterval starts
  2.Merge overlapping intervals
  3.Add remaining intervals
*/
