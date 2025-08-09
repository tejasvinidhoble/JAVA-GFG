class Solution {
    public int countPS(String s) {
        int n = s.length();
        int count = 0;

        // Odd length palindromes (center at each char)
        for (int center = 0; center < n; center++) {
            int l = center, r = center;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 >= 2) count++;
                l--;
                r++;
            }
        }

        // Even length palindromes (center between two chars)
        for (int center = 0; center < n - 1; center++) {
            int l = center, r = center + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 >= 2) count++;
                l--;
                r++;
            }
        }

        return count;
    }
}
