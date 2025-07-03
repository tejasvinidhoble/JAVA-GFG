class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
         if (s == null || s.length() == 0 || k == 0) {
            return -1;
        }

        int left = 0, right = 0, maxLength = -1;
        HashMap<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            // Add current character to the map
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            // If map size exceeds k, shrink window from the left
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            // If map size is exactly k, update maxLength
            if (map.size() == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }

            right++;
        }

        return maxLength;
    }
}