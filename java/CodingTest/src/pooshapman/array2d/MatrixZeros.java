package pooshapman.array2d;

import java.util.HashSet;
import java.util.Set;

public class MatrixZeros {
    public static void main(String[] args) {
        int [][] grid = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};

        solve(grid);
    }

    private static void solve(int[][] grid) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (row.contains(i) || col.contains(j)) {
                    grid[i][j] = 0;
                }
            }
        }

        print(grid);
    }

    private static void print(int[][] grid) {
        for (int[] ints : grid) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }
}
