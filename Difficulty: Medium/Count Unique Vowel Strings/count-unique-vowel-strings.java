class Solution {
    public int vowelCount(String s) {
        // code here
         Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Map<Character, Integer> freq = new HashMap<>();

        
        for (char ch : s.toCharArray()) {
            if (vowels.contains(ch)) {
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            }
        }

       
        if (freq.isEmpty()) return 0;

        
        int selectionWays = 1;
        for (int count : freq.values()) {
            selectionWays *= count;
        }

        
        int permutationWays = factorial(freq.size());


        return selectionWays * permutationWays;
    }

  
    private int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}