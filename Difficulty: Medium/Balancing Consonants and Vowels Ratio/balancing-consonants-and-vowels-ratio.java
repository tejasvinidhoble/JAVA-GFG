import java.util.*;

class Solution {
    public int countBalanced(String[] arr) {
        int n = arr.length;
        int[] balanceArr = new int[n]; // balance[i] = vowels - consonants in arr[i]

        for (int i = 0; i < n; i++) {
            int vowels = 0, consonants = 0;
            for (char c : arr[i].toCharArray()) {
                if (isVowel(c)) vowels++;
                else consonants++;
            }
            balanceArr[i] = vowels - consonants;
        }

        // Now count subarrays with prefix sum difference = 0
        Map<Integer, Integer> prefixMap = new HashMap<>();
        int prefixSum = 0;
        int count = 0;
        prefixMap.put(0, 1); // Base case: sum 0 before any elements

        for (int val : balanceArr) {
            prefixSum += val;
            count += prefixMap.getOrDefault(prefixSum, 0);
            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
