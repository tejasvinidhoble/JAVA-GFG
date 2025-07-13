class Solution {
    public int nonLisMaxSum(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];         // Length of LIS ending at i
        int[] sum = new int[n];        // Sum of LIS ending at i

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            sum[i] = arr[i];
        }

        // Build DP arrays
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        sum[i] = sum[j] + arr[i];
                    } else if (dp[j] + 1 == dp[i]) {
                        // Choose the LIS with minimum sum
                        sum[i] = Math.min(sum[i], sum[j] + arr[i]);
                    }
                }
            }
        }

        // Find the minimum sum of all LIS of maximum length
        int maxLen = 0;
        int minLISsum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                minLISsum = sum[i];
            } else if (dp[i] == maxLen) {
                minLISsum = Math.min(minLISsum, sum[i]);
            }
        }

        // Total array sum
        int totalSum = 0;
        for (int x : arr) totalSum += x;

        return totalSum - minLISsum;
    }
}
