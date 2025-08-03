import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> applyDiff2D(int[][] mat, int[][] opr) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] diff = new int[n + 2][m + 2];  // Extra space to avoid index out-of-bound

        // Step 1: Apply difference array logic
        for (int[] op : opr) {
            int v = op[0];
            int r1 = op[1];
            int c1 = op[2];
            int r2 = op[3];
            int c2 = op[4];

            diff[r1][c1] += v;
            diff[r2 + 1][c1] -= v;
            diff[r1][c2 + 1] -= v;
            diff[r2 + 1][c2 + 1] += v;
        }

        // Step 2: Row-wise prefix sum
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }

        // Step 3: Column-wise prefix sum
        for (int j = 0; j <= m; j++) {
            for (int i = 1; i <= n; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }

        // Step 4: Create final matrix by applying diff to mat
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(mat[i][j] + diff[i][j]);
            }
            result.add(row);
        }

        return result;
    }
}
