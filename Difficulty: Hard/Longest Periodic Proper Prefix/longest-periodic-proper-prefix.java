class Solution {
    int getLongestPrefix(String s) {
        int n = s.length();
        if (n <= 1) return -1;

        int[] pi = new int[n];
        for (int i = 1; i < n; i++) {
            int j = pi[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) j = pi[j - 1];
            if (s.charAt(i) == s.charAt(j)) j++;
            pi[i] = j;
        }

        int b = pi[n - 1];       // largest border
        if (b == 0) return -1;   // no border -> no periodic proper prefix

        // descend the pi-chain to find the smallest positive border
        while (b > 0 && pi[b - 1] > 0) {
            b = pi[b - 1];
        }

        return n - b; // longest proper prefix = n - smallest_border
    }
}
