package com.yavuzeroglu.yemeksiparisapp.di

import com.yavuzeroglu.yemeksiparisapp.data.datasource.YemekDataSource
import com.yavuzeroglu.yemeksiparisapp.data.repo.YemekRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideYemekRepository(yemekDataSource: YemekDataSource): YemekRepository {
        return YemekRepository(yemekDataSource)
    }

    @Provides
    @Singleton
    fun provideYemekDataSource(): YemekDataSource {
        return YemekDataSource()
    }
}