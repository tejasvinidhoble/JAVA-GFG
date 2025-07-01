class Solution {
    public int substrCount(String s, int k) {
        // code here
         if (s == null || s.length() < k) return 0;

        Map<Character, Integer> freqMap = new HashMap<>();
        int count = 0;

        // Initialize the first window of size k
        for (int i = 0; i < k; i++) {
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (freqMap.size() == k - 1) count++;

        // Slide the window across the string
        for (int i = k; i < s.length(); i++) {
            // Remove the character going out of the window
            char outChar = s.charAt(i - k);
            freqMap.put(outChar, freqMap.get(outChar) - 1);
            if (freqMap.get(outChar) == 0) {
                freqMap.remove(outChar);
            }

            // Add the new character coming into the window
            char inChar = s.charAt(i);
            freqMap.put(inChar, freqMap.getOrDefault(inChar, 0) + 1);

            // Check if current window has exactly k - 1 distinct characters
            if (freqMap.size() == k - 1) count++;
        }

        return count;
    }
}