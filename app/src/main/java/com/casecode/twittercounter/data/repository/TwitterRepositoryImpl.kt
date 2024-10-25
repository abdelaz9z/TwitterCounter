package com.casecode.twittercounter.data.repository

import com.casecode.twittercounter.data.model.TweetRequest
import com.casecode.twittercounter.data.model.TweetsResponse
import com.casecode.twittercounter.data.retrofit.TweetsApiService
import com.casecode.twittercounter.domain.repository.TwitterRepository
import retrofit2.Response
import javax.inject.Inject

/**
 * Implementation of the [TwitterRepository] interface, responsible for posting tweets
 * by interacting with the [TweetsApiService].
 *
 * @property tweetsApiService The API service used to communicate with the Twitter API.
 */
class TwitterRepositoryImpl @Inject constructor(
    private val tweetsApiService: TweetsApiService
) : TwitterRepository {

    /**
     * Posts a tweet to the server.
     *
     * @param tweetText The content of the tweet to post.
     * @return A [Response] containing the [TweetsResponse], which includes the posted tweet's details.
     */
    override suspend fun postTweet(tweetText: String): Response<TweetsResponse> {
        // Create the request body using the TweetRequest data class
        val requestBody = TweetRequest(text = tweetText)

        // Call the API service to post the tweet
        return tweetsApiService.postTweet(requestBody)
    }
}

