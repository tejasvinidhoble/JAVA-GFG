class Solution {
    public int maxCircularSum(int arr[]) {
        // code here
         int n = arr.length;
        int totalSum = 0;

        int currentMax = arr[0];
        int maxKadane = arr[0];

        int currentMin = arr[0];
        int minKadane = arr[0];

        for (int i = 1; i < n; i++) {
            int val = arr[i];
            totalSum += val;


            currentMax = Math.max(val, currentMax + val);
            maxKadane = Math.max(maxKadane, currentMax);

           
            currentMin = Math.min(val, currentMin + val);
            minKadane = Math.min(minKadane, currentMin);
        }

      
        totalSum += arr[0];

        
        if (totalSum == minKadane) {
            return maxKadane;
        }

       
        return Math.max(maxKadane, totalSum - minKadane);
    }
}
