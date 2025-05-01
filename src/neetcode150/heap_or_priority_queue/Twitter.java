package neetcode150.heap_or_priority_queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Created by sunjy on 4/30/25
 */
public class Twitter {

    private static int timestamp = 0;

    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<Tweet>> tweetMap;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        Set<Integer> users = followMap.getOrDefault(userId, new HashSet<>());
        users.add(userId);

        for (int uid : users) {
            List<Tweet> tweets = tweetMap.get(uid);
            if (tweets != null) {
                for (int i = tweets.size() - 1; i >= Math.max(0, tweets.size() - 10); i--) {
                    pq.offer(tweets.get(i));
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            res.add(pq.poll().tweetId);
            count++;
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }

    private static class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

}
