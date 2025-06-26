class Solution {
    public ArrayList<Integer> largestSubset(int[] arr) {
        // code here
         int n = arr.length;
        Arrays.sort(arr);

        
        ArrayList<Integer>[] dp = new ArrayList[n];

      
        for (int i = 0; i < n; i++) {
            dp[i] = new ArrayList<>();
            dp[i].add(arr[i]);
        }

       
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && dp[j].size() + 1 > dp[i].size()) {
                    dp[i] = new ArrayList<>(dp[j]);
                    dp[i].add(arr[i]);
                } else if (arr[i] % arr[j] == 0 && dp[j].size() + 1 == dp[i].size()) {
                    ArrayList<Integer> temp = new ArrayList<>(dp[j]);
                    temp.add(arr[i]);
                    
                    if (isLexGreater(temp, dp[i])) {
                        dp[i] = temp;
                    }
                }
            }
        }

       
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dp[i].size() > result.size()) {
                result = dp[i];
            } else if (dp[i].size() == result.size() && isLexGreater(dp[i], result)) {
                result = dp[i];
            }
        }

        Collections.sort(result); 
        return result;
    }

   
    private boolean isLexGreater(ArrayList<Integer> a, ArrayList<Integer> b) {
        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) > b.get(i);
            }
        }
        return a.size() > b.size();
    }
}