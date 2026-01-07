class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        int[] freq = new int[100001]; // because arr[i] <= 10^5
        int distinctCount = 0;

        // First window
        for (int i = 0; i < k; i++) {
            if (freq[arr[i]] == 0) {
                distinctCount++;
            }
            freq[arr[i]]++;
        }
        ans.add(distinctCount);

        // Sliding window
        for (int i = k; i < arr.length; i++) {

            // Remove outgoing element
            freq[arr[i - k]]--;
            if (freq[arr[i - k]] == 0) {
                distinctCount--;
            }

            // Add incoming element
            if (freq[arr[i]] == 0) {
                distinctCount++;
            }
            freq[arr[i]]++;

            ans.add(distinctCount);
        }

        return ans;
    }
}