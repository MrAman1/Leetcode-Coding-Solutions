class Solution {
    public int[] twoSum(int[] nums, int target) {
        int b = nums.length;
        int []a=new int[2] ;
        for(int i = 0; i<b;i++){
            for(int j= i+1;j<b;j++){
                if(nums[i]+nums[j] == target){
                    a[0] = i;
                    a[1]=j;


                }
            }
        }
        return a;
    }
}