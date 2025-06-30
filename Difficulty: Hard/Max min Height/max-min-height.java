class Solution {
    public int maxMinHeight(int[] arr, int k, int w) {
        int n = arr.length;
        int left = getMin(arr);
        int right = left + k + 1; 
        int answer = left;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canAchieve(arr, n, k, w, mid)) {
                answer = mid;
                left = mid + 1; 
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    
    private boolean canAchieve(int[] arr, int n, int k, int w, int target) {
        int[] water = new int[n + 1]; 
        int waterUsed = 0;
        int currentWater = 0;

        for (int i = 0; i < n; i++) {
            currentWater += water[i];

            if (arr[i] + currentWater < target) {
                int required = target - (arr[i] + currentWater);

                if (required > k - waterUsed) {
                    return false; 
                }

                waterUsed += required;
                currentWater += required;

                if (i + w < n) {
                    water[i + w] -= required;
                }
            }
        }
        return true;
    }

   
    private int getMin(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            min = Math.min(min, num);
        }
        return min;
    }
}
