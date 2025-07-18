class Solution {

    long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    int lcmTriplets(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 6;

        long maxLCM = 0;

        // Handle even n (n is divisible by 2)
        if (n % 2 == 0) {
            // If n is divisible by 3 also
            if (n % 3 == 0) {
                maxLCM = lcm(n - 1, lcm(n - 2, n - 3));
            } else {
                maxLCM = lcm(n, lcm(n - 1, n - 3));
            }
        } else {
            maxLCM = lcm(n, lcm(n - 1, n - 2));
        }

        return (int) maxLCM;
    }
}
