package com.farzin.sms.repository

interface SMSRepository {

    suspend fun sendSMS(phoneNumber:String,textMsg:String)

}