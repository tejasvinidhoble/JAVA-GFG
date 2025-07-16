class Solution {
    public static int countNumbers(int n) {
        int sqrt = (int) Math.sqrt(n) + 1;

        
        boolean[] isPrime = new boolean[sqrt + 1];
        for (int i = 2; i <= sqrt; i++) isPrime[i] = true;

        for (int i = 2; i * i <= sqrt; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= sqrt; j += i) {
                    isPrime[j] = false;
                }
            }
        }

       
        java.util.List<Integer> primes = new java.util.ArrayList<>();
        for (int i = 2; i <= sqrt; i++) {
            if (isPrime[i]) primes.add(i);
        }

        int count = 0;

      
        for (int p : primes) {
            long val = 1L;
            for (int i = 0; i < 8; i++) val *= p;
            if (val <= n) count++;
            else break; 
        }

        int sz = primes.size();
        for (int i = 0; i < sz; i++) {
            long pSquare = 1L * primes.get(i) * primes.get(i);
            for (int j = i + 1; j < sz; j++) {
                long qSquare = 1L * primes.get(j) * primes.get(j);
                if (pSquare * qSquare <= n) {
                    count++;
                } else {
                    break; 
                }
            }
        }

        return count;
    }
}

