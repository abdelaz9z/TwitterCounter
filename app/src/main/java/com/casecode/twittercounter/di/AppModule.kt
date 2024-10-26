package com.casecode.twittercounter.di

import android.content.Context
import com.casecode.twittercounter.ui.utils.ConnectivityManagerNetworkMonitor
import com.casecode.twittercounter.ui.utils.NetworkMonitor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideConnectivityManagerNetworkMonitor(
        @ApplicationContext context: Context,
    ): NetworkMonitor = ConnectivityManagerNetworkMonitor(context)
}