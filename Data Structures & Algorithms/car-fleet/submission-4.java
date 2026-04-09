// class Solution {
//     public int carFleet(int target, int[] position, int[] speed) {
//         int n=position.length;
//         int[][] map = new int[n][2];
//         for(int i=0;i<n;i++){
//             map[i][0]=position[i];
//             map[i][1]=speed[i];
//         }
//         Arrays.sort(map,(a,b)->b[0]-a[0]);
//         Deque<Double> ans=new ArrayDeque<>();
//         for(int i=0;i<n;i++){
//             double time= (double)(target-map[i][0])/map[i][1];
//             if(ans.isEmpty())ans.push(time);
//             else if(time<=ans.peek())continue;
//             else ans.push(time);
//         }
//         return ans.size();
//     }
// }

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        
        // Combine position and speed
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        
        // Sort cars by starting position descending
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);
        
        int fleets = 0;
        double lastTime = 0.0;  // time of last fleet
        
        for (int i = 0; i < n; i++) {
            double time = (double)(target - cars[i][0]) / cars[i][1];
            
            // If current car takes longer than last fleet, it forms a new fleet
            if (time > lastTime) {
                fleets++;
                lastTime = time;
            }
            // else it joins the fleet ahead, do nothing
        }
        
        return fleets;
    }
}