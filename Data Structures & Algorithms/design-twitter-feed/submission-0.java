class Post {
    int userId;
    int tweetId;
    int time;

    public Post(int userId, int tweetId, int time) {
        this.userId = userId;
        this.tweetId = tweetId;
        this.time = time;
    }
}

class Twitter {
    Map<Integer, Set<Integer>> map;
    PriorityQueue<Post> pq;
    int time = 0;

    public Twitter() {
        map = new HashMap<>();
        pq = new PriorityQueue(Comparator.comparingInt((Post a)-> a.time).reversed());
    }

    public void postTweet(int userId, int tweetId) {
        pq.offer(new Post(userId, tweetId, time));
        time++;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        Stack<Post> stack = new Stack<>();

        while (!pq.isEmpty() && ans.size() < 10) {
            Post curr = pq.poll();
            stack.push(curr);

            if (curr.userId == userId ||
                (map.containsKey(userId) &&
                 map.get(userId).contains(curr.userId))) {

                ans.add(curr.tweetId);
            }
        }

        while (!stack.isEmpty()) {
            pq.offer(stack.pop());
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {
        map.putIfAbsent(followerId, new HashSet<>());
        map.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (map.containsKey(followerId)) {
            map.get(followerId).remove(followeeId);
        }
    }
}
