import java.util.*;

class Solution {
    public int cntSubarrays(int[] arr, int k) {
        // HashMap to store the frequency of prefix sums
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        int count = 0;
        int currentSum = 0;

        // To handle the case where prefix sum itself equals k
        prefixSumCount.put(0, 1);

        // Traverse the array
        for (int num : arr) {
            currentSum += num;

            // Check if (currentSum - k) has occurred before
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }

            // Update the frequency of current prefix sum
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}
