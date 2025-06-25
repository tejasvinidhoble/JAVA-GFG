class Solution {
    boolean sameFreq(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();

        // Step 1: Count frequency of each character
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Count frequency of frequencies
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int freq : freqMap.values()) {
            countMap.put(freq, countMap.getOrDefault(freq, 0) + 1);
        }

        // Case 1: All frequencies are same
        if (countMap.size() == 1) {
            return true;
        }

        // Case 2: Exactly two frequencies present
        if (countMap.size() == 2) {
            int freq1 = 0, freq2 = 0, count1 = 0, count2 = 0;
            int i = 0;

            for (int freq : countMap.keySet()) {
                if (i == 0) {
                    freq1 = freq;
                    count1 = countMap.get(freq);
                } else {
                    freq2 = freq;
                    count2 = countMap.get(freq);
                }
                i++;
            }

            // Condition 1: One character with frequency 1 can be removed
            if ((freq1 == 1 && count1 == 1) || (freq2 == 1 && count2 == 1)) {
                return true;
            }

            // Condition 2: Difference between frequencies is 1 and the higher frequency occurs once
            if ((Math.abs(freq1 - freq2) == 1) && ((freq1 > freq2 && count1 == 1) || (freq2 > freq1 && count2 == 1))) {
                return true;
            }
        }

        return false;
    }
}
