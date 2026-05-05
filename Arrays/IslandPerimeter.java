//Problem : Island Perimeter
//Approach : single pass and minimal checks for optimal solution
//Time Complexity : O(m x n)
//Space Complexity : O(1)

/*
Idea

This is essentially a refined version of Approach 2, but cleaner:

Add 4 for every land cell
Subtract 2 for each top neighbor
Subtract 2 for each left neighbor

This avoids redundant checks entirely.

Why optimal?
Minimal condition checks
No extra counters like shared
Single traversal
*/

public class IslandPerimeter {

    public static int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int perimeter = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    perimeter += 4;

                    // check top neighbor
                    if (i > 0 && grid[i - 1][j] == 1) {
                        perimeter -= 2;
                    }

                    // check left neighbor
                    if (j > 0 && grid[i][j - 1] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }

        return perimeter;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0,1,0,0},
            {1,1,1,0},
            {0,1,0,0},
            {1,1,0,0}
        };

        int result = islandPerimeter(grid);
        System.out.println("Island Perimeter: " + result);
    }
}
