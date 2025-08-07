import java.util.*;

class Solution {
    public int minDifference(String[] arr) {
        int[] seconds = new int[arr.length];

        // Convert all times to total seconds from midnight
        for (int i = 0; i < arr.length; i++) {
            String[] parts = arr[i].split(":");
            int h = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);
            int s = Integer.parseInt(parts[2]);
            seconds[i] = h * 3600 + m * 60 + s;
        }

        // Sort the seconds array
        Arrays.sort(seconds);

        // Find the minimum difference between consecutive times
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < seconds.length; i++) {
            minDiff = Math.min(minDiff, seconds[i] - seconds[i - 1]);
        }

        // Check circular difference (last and first after midnight)
        int wrapAroundDiff = 86400 - seconds[seconds.length - 1] + seconds[0]; // 86400 = 24*60*60
        minDiff = Math.min(minDiff, wrapAroundDiff);

        return minDiff;
    }
}
