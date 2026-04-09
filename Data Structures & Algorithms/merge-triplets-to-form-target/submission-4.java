class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int num1=0;
        int num2=0;
        int num3=0;
        for(int[] triplet:triplets){
            if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                num1=Math.max(num1,triplet[0]);
                num2=Math.max(num2,triplet[1]);
                num3=Math.max(num3,triplet[2]);
            }
        }
        int[] ans=new int[]{num1,num2,num3};
        return Arrays.equals(ans,target)?true:false;
    }
}
