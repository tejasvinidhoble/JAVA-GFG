class Solution {
    public int splitArray(int[] arr, int k) {
        int max = 0, sum = 0;
        
        // Find the maximum element and total sum of the array
        for (int num : arr) {
            max = Math.max(max, num);
            sum += num;
        }
        
        int low = max;
        int high = sum;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (canSplit(arr, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low; // or high, both are same here
    }
    
    // Helper function to check if we can split array into <= k subarrays with max sum <= maxSum
    private boolean canSplit(int[] arr, int k, int maxSum) {
        int count = 1;
        int currentSum = 0;
        
        for (int num : arr) {
            if (currentSum + num > maxSum) {
                count++;
                currentSum = num;
                
                if (count > k) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }
        
        return true;
    }
};
