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
        for(int i=0;i<2;i++){
            if(target[0]!=num1)return false;
            if(target[1]!=num2)return false;
            if(target[2]!=num3)return false;
        }
        return true;
    }
}
