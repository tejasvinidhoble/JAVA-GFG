class Solution {
    public int maxRectSum(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int maxSum = Integer.MIN_VALUE;

        for (int top = 0; top < rows; top++) {
            int[] temp = new int[cols]; // temporary row sum

            for (int bottom = top; bottom < rows; bottom++) {
                // Add current row to temp array (column-wise)
                for (int col = 0; col < cols; col++) {
                    temp[col] += mat[bottom][col];
                }

                // Find max subarray sum for current row range using Kadane's
                int currMax = kadane(temp);
                maxSum = Math.max(maxSum, currMax);
            }
        }

        return maxSum;
    }

    // Standard Kadane’s Algorithm (handles all-negative arrays too)
    private int kadane(int[] arr) {
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
