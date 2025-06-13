class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
        int low = 1;
        int high = getMax(arr);
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canEatAll(arr, k, mid)) {
                result = mid;      // try smaller speed
                high = mid - 1;
            } else {
                low = mid + 1;     // need more speed
            }
        }

        return result;
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    private boolean canEatAll(int[] arr, int k, int speed) {
        int totalHours = 0;
        for (int bananas : arr) {
            totalHours += (bananas + speed - 1) / speed; // ceiling division
        }
        return totalHours <= k;
    }
}

 