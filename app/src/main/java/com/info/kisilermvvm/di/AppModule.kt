package com.info.kisilermvvm.di

import android.content.Context
import androidx.room.Room
import com.info.kisilermvvm.data.entity.Kisiler
import com.info.kisilermvvm.data.repo.KisilerDaoRepository
import com.info.kisilermvvm.room.KisilerDao
import com.info.kisilermvvm.room.Veriabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideKisilerDaoRepository(kdao:KisilerDao):KisilerDaoRepository{
        return KisilerDaoRepository(kdao)
    }
    @Provides
    @Singleton
    fun provideKisilerDao(@ApplicationContext context:Context):KisilerDao{
        val vt= Room.databaseBuilder(context,Veriabani::class.java,"rehber.db")
            .createFromAsset("rehber.db").build()
        return vt.getKisilerDao()

    }


}