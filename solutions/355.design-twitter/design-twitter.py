import heapq
class Twitter(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.time = 0
        self.tweets = {}
        self.followee = {} # followerId : followeeIDs (set)

    def postTweet(self, userId, tweetId):
        """
        Compose a new tweet.
        :type userId: int
        :type tweetId: int
        :rtype: void
        """
        self.time += 1
        self.tweets[userId] = self.tweets.get(userId, []) + [(-self.time, tweetId)]

    def getNewsFeed(self, userId):
        """
        Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
        :type userId: int
        :rtype: List[int]
        """
        followees = self.followee.get(userId, set()) | set([userId])
        tweets = []
        for followeeId in followees:
            tweets.extend(self.tweets.get(followeeId, []))
        heapq.heapify(tweets)

        l = min(10, len(tweets))
        rst = []
        for i in range(l):
            tweet = heapq.heappop(tweets)
            rst.append(tweet[1])
        return rst

    def follow(self, followerId, followeeId):
        """
        Follower follows a followee. If the operation is invalid, it should be a no-op.
        :type followerId: int
        :type followeeId: int
        :rtype: void
        """
        if not self.followee.get(followerId):
            self.followee[followerId] = set([followerId])
        self.followee[followerId].add(followeeId)

    def unfollow(self, followerId, followeeId):
        """
        Follower unfollows a followee. If the operation is invalid, it should be a no-op.
        :type followerId: int
        :type followeeId: int
        :rtype: void
        """
        followeeSet = self.followee.get(followerId, set([followerId]))
        if followerId in followeeSet:
            followeeSet.discard(followeeId)


# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(1,5)
# param_2 = obj.getNewsFeed(1)
# obj.follow(1,2)
# obj.postTweet(2,6)
# param_3 = obj.getNewsFeed(1)
# obj.unfollow(1,2)
# param_4 = obj.getNewsFeed(1)
# aa = 2