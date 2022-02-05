class Solution {
    public int maxProfit(int[] prices) {
       int max=Integer.MIN_VALUE;
       int min=Integer.MAX_VALUE;
       int n=prices.length;
       for(int i=0;i<n;i++){
           min=Math.min(min,prices[i]);
           if(prices[i]-min>max) max=prices[i]-min;
       }
        return max;
    }
}