package com.farzin.sms.di

import android.content.Context
import android.os.Build
import android.telephony.SmsManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSms(
        @ApplicationContext context:Context
    ): SmsManager = context.getSystemService(SmsManager::class.java)

}