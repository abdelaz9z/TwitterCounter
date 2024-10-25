package com.casecode.twittercounter.domain.usecase

import com.casecode.twittercounter.data.model.TweetsResponse
import com.casecode.twittercounter.domain.repository.TwitterRepository
import javax.inject.Inject

/**
 * Use case for posting a tweet through the Twitter API.
 * This class encapsulates the logic for interacting with the [TwitterRepository]
 * to post a tweet and handle the result.
 *
 * @property repository The [TwitterRepository] instance used to perform the tweet posting operation.
 */
class PostTweetUseCase @Inject constructor(
    private val repository: TwitterRepository
) {

    /**
     * Invokes the use case to post a tweet with the provided text.
     *
     * @param tweetText The content of the tweet to be posted.
     * @return A [Result] containing the [TweetsResponse] if the operation is successful,
     *         or an exception if it fails.
     */
    suspend operator fun invoke(tweetText: String): Result<TweetsResponse> {
        return try {
            // Attempt to post the tweet using the repository
            val response = repository.postTweet(tweetText)

            // Check if the response is successful
            if (response.isSuccessful) {
                // Return the successful response wrapped in a Result
                Result.success(response.body()!!)
            } else {
                // Handle error response
                Result.failure(Exception("Error posting tweet: ${response.errorBody()?.string()}"))
            }
        } catch (e: Exception) {
            // Catch any exceptions and return as a failure result
            Result.failure(e)
        }
    }
}
