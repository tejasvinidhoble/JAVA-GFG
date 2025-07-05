class Solution {
    public int maxSum(int arr[]) {
        int maxSum = Integer.MIN_VALUE;

        // Just check all adjacent pairs (since maximum will come when both numbers are large)
        for (int i = 0; i < arr.length - 1; i++) {
            int sum = arr[i] + arr[i + 1];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
