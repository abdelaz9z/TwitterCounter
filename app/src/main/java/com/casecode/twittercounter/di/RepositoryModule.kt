package com.casecode.twittercounter.di

import com.casecode.twittercounter.data.repository.TwitterRepositoryImpl
import com.casecode.twittercounter.domain.repository.TwitterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * A Dagger module for providing repository-related dependencies. This module binds the
 * [TwitterRepositoryImpl] implementation to the [TwitterRepository] interface, allowing
 * for dependency injection throughout the application.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    /**
     * Binds the [TwitterRepositoryImpl] implementation to the [TwitterRepository] interface.
     *
     * @param twitterRepositoryImpl The implementation of [TwitterRepository] to be provided.
     * @return An instance of [TwitterRepository] that will be used for dependency injection.
     */
    @Binds
    @Singleton
    abstract fun bindTwitterRepository(
        twitterRepositoryImpl: TwitterRepositoryImpl
    ): TwitterRepository
}
