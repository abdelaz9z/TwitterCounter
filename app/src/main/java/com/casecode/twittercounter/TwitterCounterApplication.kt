package com.casecode.twittercounter

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Application class for the TwitterCounter app, serving as the application-level
 * entry point for dependency injection using Dagger Hilt.
 */
@HiltAndroidApp
class TwitterCounterApplication : Application()
