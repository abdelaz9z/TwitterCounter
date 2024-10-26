package com.casecode.twittercounter.ui.screen

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.casecode.twittercounter.R
import com.casecode.twittercounter.domain.usecase.PostTweetUseCase
import com.casecode.twittercounter.ui.utils.NetworkMonitor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for managing the UI-related data for posting tweets in the TwitterCounter app.
 * This ViewModel uses [PostTweetUseCase] to handle tweet posting logic and maintains
 * the state of the tweet text and response messages.
 *
 * @property postTweetUseCase Use case for posting a tweet.
 * @constructor Creates a new instance of [TwitterViewModel].
 */
@HiltViewModel
class TwitterViewModel @Inject constructor(
    private val postTweetUseCase: PostTweetUseCase,
    private val networkMonitor: NetworkMonitor
) : ViewModel() {

    // State for network connectivity
    private val _isOnline = MutableStateFlow(false)

    // Mutable state for the tweet text input
    private val _tweetText = MutableStateFlow("")
    val tweetText: StateFlow<String> = _tweetText.asStateFlow()

    // Mutable state for the response message
    private val _postResponse = MutableStateFlow<Int?>(null)
    val postResponse: StateFlow<Int?> = _postResponse.asStateFlow()

    private val _isPosting = MutableStateFlow(false)
    val isPosting: StateFlow<Boolean> = _isPosting.asStateFlow()

    init {
        viewModelScope.launch {
            networkMonitor.isOnline.collect { isOnline -> _isOnline.value = isOnline }
        }
    }

    /**
     * Updates the tweet text input.
     *
     * @param text The new tweet text to be set.
     */
    fun updateTweetText(text: String) {
        _tweetText.value = text
    }

    /**
     * Clears the tweet text input.
     */
    fun clearTweetText() {
        _tweetText.value = ""
    }

    /**
     * Clears the response message.
     */
    fun clearPostResponse() {
        _postResponse.value = null
    }

    /**
     * Displays the response message using a string resource ID.
     *
     * @param message The string resource ID of the message to be displayed.
     */
    fun showPostResponse(@StringRes message: Int) {
        _postResponse.value = message
    }

    /**
     * Posts the tweet using the [PostTweetUseCase].
     * If the tweet text is valid, it triggers the use case and handles the response.
     * Displays appropriate messages based on the success or failure of the operation.
     */
    fun postTweet() {

        if (!_isOnline.value) {
            showPostResponse(R.string.not_connected)
            return
        }

        val text = _tweetText.value
        if (text.isNotBlank()) {
            viewModelScope.launch {
                _isPosting.value = true // Start loading
                try {
                    val response = postTweetUseCase(text)
                    if (response.isSuccess) {
                        showPostResponse(R.string.tweet_posted_successfully)
                        clearTweetText()
                    } else {
                        showPostResponse(R.string.error_posting_tweet)
                    }
                } catch (e: Exception) {
                    showPostResponse(R.string.something_went_wrong)
                } finally {
                    _isPosting.value = false // Stop loading
                }
            }
        } else {
            showPostResponse(R.string.please_enter_a_tweet)
        }
    }
}
