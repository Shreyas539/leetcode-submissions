class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1; // peak is on the right
            } else {
                right = mid; // peak is on the left (including mid)
            }
        }
        return left; // or right, both converge to the peak index
    }
}