class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        // Initialize with the first element
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int tempMax = maxSoFar; // Store the 'old' max

            // Update max: check current number, current * oldMax, and current * oldMin
            maxSoFar = Math.max(current, Math.max(current * tempMax, current * minSoFar));

            // Update min: check current number, current * oldMax, and current * oldMin
            minSoFar = Math.min(current, Math.min(current * tempMax, current * minSoFar));

            // The global result is the highest maxSoFar we've ever seen
            result = Math.max(result, maxSoFar);
        }

        return result;
    }
}