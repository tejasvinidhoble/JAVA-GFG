class Solution {
    public String minWindow(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n][m];

        // initialize dp with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        // base case for first character of s2
        if (s1.charAt(0) == s2.charAt(0)) {
            dp[0][0] = 0;
        }

        for (int i = 1; i < n; i++) {
            // propagate j = 0
            if (s1.charAt(i) == s2.charAt(0)) {
                dp[i][0] = i;
            } else {
                dp[i][0] = dp[i - 1][0];
            }

            // fill remaining dp
            for (int j = 1; j < m; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // find minimum window
        int minLen = Integer.MAX_VALUE;
        int start = -1;

        for (int i = 0; i < n; i++) {
            if (dp[i][m - 1] != -1) {
                int len = i - dp[i][m - 1] + 1;
                if (len < minLen) {
                    minLen = len;
                    start = dp[i][m - 1];
                }
            }
        }

        return start == -1 ? "" : s1.substring(start, start + minLen);
    }
}
