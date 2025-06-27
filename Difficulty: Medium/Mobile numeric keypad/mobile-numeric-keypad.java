class Solution {
    public int getCount(int n) {
        if (n <= 0) return 0;

        // Allowed moves for each key
        int[][] moves = {
            {0, 8},        // 0 can move to 0, 8
            {1, 2, 4},     // 1 can move to 1, 2, 4
            {2, 1, 3, 5},  // 2 can move to 2, 1, 3, 5
            {3, 2, 6},     // 3 can move to 3, 2, 6
            {4, 1, 5, 7},  // 4 can move to 4, 1, 5, 7
            {5, 2, 4, 6, 8}, // 5 can move to 5, 2, 4, 6, 8
            {6, 3, 5, 9},  // 6 can move to 6, 3, 5, 9
            {7, 4, 8},     // 7 can move to 7, 4, 8
            {8, 0, 5, 7, 9}, // 8 can move to 8, 0, 5, 7, 9
            {9, 6, 8}      // 9 can move to 9, 6, 8
        };

       
        long[][] dp = new long[n + 1][10];

        
        for (int digit = 0; digit <= 9; digit++) {
            dp[1][digit] = 1;
        }

        
        for (int len = 2; len <= n; len++) {
            for (int digit = 0; digit <= 9; digit++) {
                dp[len][digit] = 0;
                for (int move : moves[digit]) {
                    dp[len][digit] += dp[len - 1][move];
                }
            }
        }

      
        long total = 0;
        for (int digit = 0; digit <= 9; digit++) {
            total += dp[n][digit];
        }

        return (int) total;  
    }
}
