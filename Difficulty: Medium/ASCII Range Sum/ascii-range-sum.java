import java.util.*;

class Solution {
    public ArrayList<Integer> asciirange(String s) {
        int n = s.length();
        HashMap<Character, Integer> firstIndex = new HashMap<>();
        HashMap<Character, Integer> lastIndex = new HashMap<>();
        
        // Step 1: Record first and last occurrence of each character
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            firstIndex.putIfAbsent(ch, i);  // only set first occurrence
            lastIndex.put(ch, i);           // always update for last occurrence
        }

        ArrayList<Integer> result = new ArrayList<>();

        // Step 2: For characters that appear more than once
        for (char ch : firstIndex.keySet()) {
            int first = firstIndex.get(ch);
            int last = lastIndex.get(ch);

            if (last > first) {
                int sum = 0;
                for (int i = first + 1; i < last; i++) {
                    sum += (int) s.charAt(i);
                }
                if (sum != 0) {
                    result.add(sum);
                }
            }
        }

        return result;
    }
}
