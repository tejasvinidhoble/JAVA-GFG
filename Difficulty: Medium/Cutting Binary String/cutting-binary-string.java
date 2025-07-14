class Solution {
    public int cuts(String s) {
        // code here
         int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // base case: empty string = 0 cuts

        Set<Integer> powersOf5 = new HashSet<>();
        int power = 1;
        while (power <= 1e9) {
            powersOf5.add(power);
            power *= 5;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (isValid(sub, powersOf5)) {
                    if (dp[j] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }

    private boolean isValid(String bin, Set<Integer> powersOf5) {
        if (bin.charAt(0) == '0') return false; // no leading zeros
        int decimal = Integer.parseInt(bin, 2);
        return powersOf5.contains(decimal);
    }
}
