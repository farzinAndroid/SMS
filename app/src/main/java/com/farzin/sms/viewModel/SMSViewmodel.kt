package com.farzin.sms.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farzin.sms.repository.SMSRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SMSViewmodel @Inject constructor(
    private val smsRepositoryImpl: SMSRepositoryImpl
) : ViewModel() {


    fun sendSMS(phoneNumber:String,textMsg:String){
        viewModelScope.launch {
            smsRepositoryImpl.sendSMS(phoneNumber,textMsg)
        }
    }

}