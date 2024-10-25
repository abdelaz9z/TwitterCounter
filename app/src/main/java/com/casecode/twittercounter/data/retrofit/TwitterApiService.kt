package com.casecode.twittercounter.data.retrofit

import com.casecode.twittercounter.data.model.TweetRequest
import com.casecode.twittercounter.data.model.TweetsResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Interface defining the Twitter API service for posting tweets.
 */
interface TweetsApiService {

    /**
     * Posts a tweet to the Twitter API.
     *
     * @param tweetRequest The request body containing the tweet's content, encapsulated in a [TweetRequest].
     * @return A [Response] wrapping a [TweetsResponse], which includes details about the posted tweet.
     */
    @POST("2/tweets")
    suspend fun postTweet(@Body tweetRequest: TweetRequest): Response<TweetsResponse>
}
