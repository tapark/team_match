package com.teddy_park.team_match.di

import android.content.Context
import androidx.room.Room
import com.teddy_park.team_match.dao.MatchDao
import com.teddy_park.team_match.database.MatchDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideMatchDatabase(
        @ApplicationContext context: Context
    ): MatchDatabase = Room
        .databaseBuilder(context, MatchDatabase::class.java, "match.db")
        .build()

    @Provides
    @Singleton
    fun provideMatchDao(matchDatabase: MatchDatabase): MatchDao = matchDatabase.posDao()

}