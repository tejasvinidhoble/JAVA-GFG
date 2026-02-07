class Solution {
    public boolean isSorted(int[] arr) {
        // code here
     int n = arr.length;
     for(int i= 1;i< n;i++){
          if(arr[i] < arr[i - 1]) {
                return false;
            }
     }
     return true;
    }
}