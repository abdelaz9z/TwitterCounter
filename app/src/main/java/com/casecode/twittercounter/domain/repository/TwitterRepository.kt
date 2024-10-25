package com.casecode.twittercounter.domain.repository

import com.casecode.twittercounter.data.model.TweetsResponse
import retrofit2.Response

/**
 * Interface defining the operations for interacting with Twitter's API related to tweets.
 * This repository abstracts the implementation details and provides a contract for posting tweets.
 */
interface TwitterRepository {

    /**
     * Posts a tweet with the given text to the Twitter API.
     *
     * @param tweetText The content of the tweet to be posted.
     * @return A [Response] wrapping a [TweetsResponse] that contains details about the posted tweet.
     */
    suspend fun postTweet(tweetText: String): Response<TweetsResponse>
}
