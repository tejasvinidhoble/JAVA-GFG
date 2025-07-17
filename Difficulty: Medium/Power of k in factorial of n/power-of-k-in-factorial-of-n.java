class Solution {
    public int maxKPower(int n, int k) {
        // code here
         Map<Integer, Integer> primeFactors = getPrimeFactors(k);
        int result = Integer.MAX_VALUE;

        // Step 2: For each prime factor, use Legendre's formula
        for (Map.Entry<Integer, Integer> entry : primeFactors.entrySet()) {
            int prime = entry.getKey();
            int powerInK = entry.getValue();

            // Count how many times 'prime' appears in n!
            int powerInNFact = 0;
            int temp = n;
            while (temp > 0) {
                temp /= prime;
                powerInNFact += temp;
            }

            // x = powerInNFact / powerInK (integer division)
            result = Math.min(result, powerInNFact / powerInK);
        }

        return result;
    }

    // Utility: Prime factorization of k
    private Map<Integer, Integer> getPrimeFactors(int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 2; i * i <= k; i++) {
            while (k % i == 0) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                k /= i;
            }
        }
        if (k > 1) {
            map.put(k, 1); // k is prime
        }
        return map;
    }
}