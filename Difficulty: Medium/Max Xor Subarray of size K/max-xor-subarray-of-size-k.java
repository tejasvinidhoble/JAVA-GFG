class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
         int n = arr.length;

        // XOR of first window
        int windowXor = 0;
        for (int i = 0; i < k; i++) {
            windowXor ^= arr[i];
        }

        int maxXor = windowXor;

        // Slide the window
        for (int i = k; i < n; i++) {
            windowXor ^= arr[i - k]; // remove left element
            windowXor ^= arr[i];     // add right element
            maxXor = Math.max(maxXor, windowXor);
        }

        return maxXor;
    }
}
