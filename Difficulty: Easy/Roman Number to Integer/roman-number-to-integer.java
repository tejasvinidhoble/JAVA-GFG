import java.util.*;
class Solution {
    public int romanToDecimal(String s) {
        Map<Character, Integer> roman = new java.util.HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int total = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int curr = roman.get(s.charAt(i));
            int next = (i + 1 < n) ? roman.get(s.charAt(i + 1)) : 0;

           
            if (curr < next) {
                total -= curr;
            } else {
                total += curr;
            }
        }

        return total;
    }
}
