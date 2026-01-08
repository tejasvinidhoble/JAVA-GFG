class Solution {
    public int countSubarrays(int[] arr, int k) {
        // code here
        return atMostK(arr, k) - atMostK(arr, k - 1);
    }

    private int atMostK(int[] arr, int k) {
        int left = 0, count = 0, oddCount = 0;

        for (int right = 0; right < arr.length; right++) {
            if (arr[right] % 2 == 1) {
                oddCount++;
            }

            while (oddCount > k) {
                if (arr[left] % 2 == 1) {
                    oddCount--;
                }
                left++;
            }

            count += (right - left + 1);
        }

        return count; 
    }
}
