package com.teddy_park.team_match.di

import com.teddy_park.team_match.dao.MatchDao
import com.teddy_park.team_match.repository.MatchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMatchRepository(matchDao: MatchDao) : MatchRepository {
        return MatchRepository(matchDao)
    }
}
