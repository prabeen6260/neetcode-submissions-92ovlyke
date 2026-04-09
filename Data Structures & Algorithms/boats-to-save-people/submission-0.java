class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n=people.length;
        int count=0;
        int l=0;
        int r=n-1;
        while(l<=r){
            if(people[l]+people[r]<=limit){
                count++;
                l++;
                r--;
            }
            else if(people[l]+people[r]>limit){
                count++;
                r--;
            }
        }
        return count;
    }
}