package com.hzzh.demo

import android.arch.lifecycle.ViewModel

/**
 * Created by dmx on 2017/8/12.
 */
class UserViewModel : ViewModel() {
    var userLiveData: UserLiveData? = null
    fun login(name: String, password: String): UserLiveData {
        if (userLiveData == null) {
            userLiveData = UserLiveData()
        }
        userLiveData!!.login(name, password)
        return userLiveData!!
    }
}