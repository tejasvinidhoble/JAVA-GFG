class Solution {
    public int totalElements(int[] arr) {
        // code here
        int maxLength = 0;
        int left = 0;
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int right = 0; right < arr.length; right++) {
            // Add the current element to the map and update its frequency
            countMap.put(arr[right], countMap.getOrDefault(arr[right], 0) + 1);

            // If the map contains more than two distinct integers, shrink the window
            while (countMap.size() > 2) {
                countMap.put(arr[left], countMap.get(arr[left]) - 1);
                if (countMap.get(arr[left]) == 0) {
                    countMap.remove(arr[left]);
                }
                left++; // Shrink the window from the left
            }

            // Update the maximum length of the valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}