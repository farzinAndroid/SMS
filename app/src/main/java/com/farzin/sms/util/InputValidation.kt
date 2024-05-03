package com.farzin.sms.util

import androidx.core.text.isDigitsOnly

object InputValidation {

    fun String.isInputValid() : Boolean{
        return this.isNotEmpty() &&
                this.isNotBlank()
                && this.isDigitsOnly()
                && this.startsWith("09")
                && this.length <= 11
    }
}