class Solution {
    public int[] getAverages(int[] nums, int k) {
        int[] ans=new int[nums.length];
        if(k==0) return nums;
        Arrays.fill(ans,-1);
    
        if(2*k+1>nums.length) return ans;
        
        long windowSum=0;
        
        for(int i=0;i<(2*k+1);i++){
            windowSum+=nums[i];
        }
        
        ans[k]=(int)(windowSum/(2*k+1));
        
        for(int i=(2*k+1);i<nums.length;i++){
            windowSum=windowSum - nums[i-(2*k+1)] + nums[i];
            ans[i-k]=(int)(windowSum/(2*k+1));
        }
    
        return ans;
    }
}