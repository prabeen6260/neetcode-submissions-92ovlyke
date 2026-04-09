class Twitter {
    private static int timestamp=0;
    Map<Integer,HashSet<Integer>> follows;
    Map<Integer,Tweet> tweets;
    class Tweet{
        int id;
        int time;
        Tweet next;
        Tweet(int id, int time){
            this.id = id;
            this.time=time;
        }
    }

    public Twitter() {
        follows = new HashMap<>();
        tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet t = new Tweet(tweetId,++timestamp);
        Tweet head = tweets.get(userId);
        t.next = head;
        tweets.put(userId,t);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b)->b.time-a.time);

        HashSet<Integer> users = new HashSet<>();
        users.add(userId);
        if(follows.containsKey(userId))users.addAll(follows.get(userId));
        for(int u:users){
            Tweet head = tweets.get(u);
            if(head!=null){
                pq.offer(head);
            }
        }
        while(!pq.isEmpty() & res.size()<10){
            Tweet top = pq.poll();
            res.add(top.id);
            if(top.next!=null)pq.offer(top.next);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId)return;
        //follows.computeIfAbsent(followerId,k->new HashSet<>()).add(followeeId);
        if(!follows.containsKey(followerId)){
            follows.put(followerId,new HashSet<>());
        }
        follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!follows.containsKey(followerId))return;
        if(followerId==followeeId)return;
        follows.get(followerId).remove(followeeId);
    }
}
