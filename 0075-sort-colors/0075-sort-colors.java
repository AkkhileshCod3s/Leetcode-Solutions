class Solution {
    public void sortColors(int[] nums) {
        int low = 0;               // Boundary for 0s (red)
        int mid = 0;               // Current element being checked
        int high = nums.length - 1; // Boundary for 2s (blue)

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { // nums[mid] == 2
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
