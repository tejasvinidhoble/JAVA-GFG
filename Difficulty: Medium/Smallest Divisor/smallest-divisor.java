class Solution {
    int smallestDivisor(int[] arr, int k) {
        // Code here
       
        int low = 1;
        int high = getMax(arr);
        int ans = high;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (sumWithDivisor(arr, mid) <= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    // Helper to find the maximum value in the array
    private int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Helper to calculate the sum of ceiling divisions
    private int sumWithDivisor(int[] arr, int divisor) {
        int sum = 0;
        for (int num : arr) {
            sum += (num + divisor - 1) / divisor;  // Equivalent to ceil(num / divisor)
        }
        return sum;
    }
}

  