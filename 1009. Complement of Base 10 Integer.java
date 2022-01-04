class Solution {
    public int bitwiseComplement(int n) {
       int result = (int)(Math.log(n) / Math.log(2));
       result++;
       int pow=(int)Math.pow(2,result)-1;
       return n==0 ? 1: n^pow;
    }
}