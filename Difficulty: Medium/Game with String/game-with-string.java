class Solution {
    public int minValue(String s, int k) {
        // Step 1: Frequency array
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 2: Max Heap (Priority Queue)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int count : freq) {
            if (count > 0) {
                maxHeap.add(count);
            }
        }

        // Step 3: Remove k characters
        while (k > 0 && !maxHeap.isEmpty()) {
            int largest = maxHeap.poll(); // Get the character with max frequency
            largest--; // Remove one occurrence
            if (largest > 0) {
                maxHeap.add(largest); // Add back if still present
            }
            k--;
        }

        // Step 4: Calculate sum of squares of remaining frequencies
        int result = 0;
        while (!maxHeap.isEmpty()) {
            int count = maxHeap.poll();
            result += count * count;
        }

        return result;
    }
}
