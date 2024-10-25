package com.casecode.twittercounter.data.model

import com.google.gson.annotations.SerializedName

/**
 * A request model representing the content of a tweet that a user wants to post.
 *
 * @property text The content of the tweet. This should be a non-empty string.
 */
data class TweetRequest(
    val text: String
)

/**
 * A response model representing a single tweet retrieved from the server.
 * It contains a single tweet with details about its content and history.
 *
 * @property tweet The tweet object containing the tweet's text, unique identifier, and edit history.
 */
data class TweetsResponse(
    @SerializedName("data")
    val tweet: Tweet
)

/**
 * A data model representing a tweet.
 *
 * @property text The main content of the tweet.
 * @property id The unique identifier for this tweet.
 * @property editHistoryTweetIds A list of identifiers representing the history of edits
 *                               for this tweet, in chronological order.
 */
data class Tweet(
    val text: String,
    val id: String,
    @SerializedName("edit_history_tweet_ids") val editHistoryTweetIds: List<String>
)
