//Problem : Island Perimeter


//Approach 1 : Better solution (Count land cells and shared edges)
//Time Complexity : O(m x n)
//Space Complexity : O(1)

/*
Idea

Instead of checking all 4 directions:

Each land cell contributes 4 edges
But if two land cells are adjacent → they share a side → subtract 2

So:

Perimeter = (number of land cells × 4) - (number of shared edges × 2)

We only check right and down to avoid double counting.
*/
public class IslandPerimeter {

    public static int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int land = 0;
        int sharedEdges = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    land++;

                    // check right neighbor
                    if (j < n - 1 && grid[i][j + 1] == 1) {
                        sharedEdges++;
                    }

                    // check down neighbor
                    if (i < m - 1 && grid[i + 1][j] == 1) {
                        sharedEdges++;
                    }
                }
            }
        }

        return land * 4 - sharedEdges * 2;
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








//Approach 2 : Optimal solution (Single pass, minimal checks)
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


