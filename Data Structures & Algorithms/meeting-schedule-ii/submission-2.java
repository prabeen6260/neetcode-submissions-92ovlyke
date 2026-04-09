/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n=intervals.size();
        int[] start = new int[n];
        int[] end= new int[n];
        int count =0;
        int result=0;
        for(int i=0;i<n;i++){
            start[i]=intervals.get(i).start;
            end[i]=intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int j=0; // pointer for end 
        for(int i=0;i<n;i++){
            if(start[i]<end[j]){
                count++;
            }
            else j++;
            result=Math.max(count,result);
        }
        return result;
    }
}
