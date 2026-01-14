import java.util.*;

class Solution {
    public int catchThieves(char[] arr, int k) {

        List<Integer> police = new ArrayList<>();
        List<Integer> thieves = new ArrayList<>();

        // Store positions
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'P') police.add(i);
            else if (arr[i] == 'T') thieves.add(i);
        }

        int i = 0, j = 0, count = 0;

        // Two-pointer matching
        while (i < police.size() && j < thieves.size()) {
            if (Math.abs(police.get(i) - thieves.get(j)) <= k) {
                count++;
                i++;
                j++;
            } else if (police.get(i) < thieves.get(j)) {
                i++;
            } else {
                j++;
            }
        }

        return count;
    }
}
