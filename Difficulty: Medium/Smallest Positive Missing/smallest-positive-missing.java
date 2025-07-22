class Solution {
    public int missingNumber(int[] arr) {
        // code here
          int n = arr.length;

       
        for (int i = 0; i < n; i++) {
            while (
                arr[i] > 0 && arr[i] <= n &&
                arr[arr[i] - 1] != arr[i]
            ) {
                
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }

        
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        
        return n + 1;
    }
}
