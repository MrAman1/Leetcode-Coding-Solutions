class Solution {
    public int minimumDeletions(int[] nums) {

        int n = nums.length;

        int min = 0;
        int max = 0;

        for(int i = 0; i < n; i++) {

            if(nums[i] < nums[min])
                min = i;

            if(nums[i] > nums[max])
                max = i;
        }

        int small = Math.min(min, max);
        int large = Math.max(min, max);

        int front = large + 1;
        int back = n - small;
        int both = small + 1 + n - large;

        return Math.min(front, Math.min(back, both));
    }
}