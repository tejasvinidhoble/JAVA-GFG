class Solution {
    public int countAtMostK(int arr[], int k) {
        // Map to store the frequency of elements in the current window
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, result = 0;

        for (int right = 0; right < arr.length; right++) {
            // Add the current element to the map
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            // If there are more than k distinct elements, shrink the window
            while (map.size() > k) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }

            // Add the count of subarrays ending at index 'right'
            result += (right - left + 1);
        }

        return result;
    }
}
