package com.keeper.keeperrecord.login

import android.os.Handler
import androidx.lifecycle.ViewModel

class LoginViewModel() : ViewModel() {

    fun login(email: String, password: String, onSuccess: () -> Unit) {

        val handler = Handler()
        handler.postDelayed({ onSuccess.invoke() }, 2000)
    }
}