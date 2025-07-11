class Solution {
    public int countConsec(int n) {
        // code here
        int total = 1 << n; 

       
        int[] dp = new int[n + 1];
        dp[0] = 1; 
        dp[1] = 2; 

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return total - dp[n];
    }
}
