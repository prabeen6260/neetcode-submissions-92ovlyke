class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] map = new int[position.length][2];
        for(int i=0;i<position.length;i++){
            map[i][0]=position[i];
            map[i][1]=speed[i];
        }
        Arrays.sort(map,(a,b)->Integer.compare(b[0],a[0]));
        Deque<Double> stack = new ArrayDeque<>();
        for(int i=0;i<position.length;i++){
            double time=(double)(target-map[i][0])/map[i][1];
            if(!stack.isEmpty() && time<=stack.peek()){
                continue;
            }
            else{
                stack.push(time);
            }
        }
        return stack.size();
    }
}
