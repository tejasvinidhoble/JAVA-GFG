class Solution {
    public int minimumCoins(int[] arr, int k) {
        // code here
          int n = arr.length;
        Arrays.sort(arr); // Step 1: Sort the array

        // Step 2: Prefix sum array
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        long minCoinsToRemove = Long.MAX_VALUE;

        // Step 3: Try each arr[i] as the lower bound x
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int upper = x + k;

            // Find index of first element > upper using binary search
            int rightIndex = upperBound(arr, upper);

            // Coins to remove from left (fully remove all coins in piles < x)
            long removeLeft = prefix[i];

            // Coins to remove from right (partially reduce piles > upper)
            long totalCoinsRight = prefix[n] - prefix[rightIndex];
            long idealCoinsRight = (long)(n - rightIndex) * upper;
            long removeRight = totalCoinsRight - idealCoinsRight;

            long totalRemoved = removeLeft + removeRight;
            minCoinsToRemove = Math.min(minCoinsToRemove, totalRemoved);
        }

        return (int) minCoinsToRemove;
    }

    // Binary search to find first index where arr[i] > target
    private int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
