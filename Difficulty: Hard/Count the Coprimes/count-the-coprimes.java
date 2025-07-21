
class Solution {
    static final int MAX = 10001;

    public int cntCoprime(int[] arr) {
        int[] freq = new int[MAX];

      
        for (int num : arr) {
            freq[num]++;
        }

       
        int[] countDivisible = new int[MAX];
        for (int i = 1; i < MAX; i++) {
            for (int j = i; j < MAX; j += i) {
                countDivisible[i] += freq[j];
            }
        }

      
        long[] pairCount = new long[MAX];
        for (int i = MAX - 1; i >= 1; i--) {
            long c = countDivisible[i];
            pairCount[i] = (c * (c - 1)) / 2;
            for (int j = i * 2; j < MAX; j += i) {
                pairCount[i] -= pairCount[j];
            }
        }

        return (int) pairCount[1];  
    }
}

