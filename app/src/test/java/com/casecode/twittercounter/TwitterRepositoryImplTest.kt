package com.casecode.twittercounter

import com.casecode.twittercounter.data.model.Tweet
import com.casecode.twittercounter.data.model.TweetRequest
import com.casecode.twittercounter.data.model.TweetsResponse
import com.casecode.twittercounter.data.repository.TwitterRepositoryImpl
import com.casecode.twittercounter.data.retrofit.TweetsApiService
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnit
import retrofit2.Response

class TwitterRepositoryImplTest {

    @get:Rule
    var mockitoRule = MockitoJUnit.rule()

    @Mock
    private lateinit var tweetsApiService: TweetsApiService

    private lateinit var twitterRepository: TwitterRepositoryImpl

    @Before
    fun setUp() {
        twitterRepository = TwitterRepositoryImpl(tweetsApiService)
    }

    @Test
    fun `postTweet should return success response`() = runBlocking {
        // Arrange
        val tweetText = "Test Tweet"
        val tweetResponse =
            TweetsResponse(Tweet(text = tweetText, id = "123", editHistoryTweetIds = listOf()))
        val response = Response.success(tweetResponse)
        `when`(tweetsApiService.postTweet(TweetRequest(tweetText))).thenReturn(response)

        // Act
        val result = twitterRepository.postTweet(tweetText)

        // Assert
        assert(result.isSuccessful)
        assert(result.body() == tweetResponse)
    }

    @Test
    fun `postTweet should return error response`() = runBlocking {
        // Arrange
        val tweetText = "Test Tweet"
        val response =
            Response.error<TweetsResponse>(400, okhttp3.ResponseBody.create(null, "Error"))
        `when`(tweetsApiService.postTweet(TweetRequest(tweetText))).thenReturn(response)

        // Act
        val result = twitterRepository.postTweet(tweetText)

        // Assert
        assert(!result.isSuccessful)
    }
}
