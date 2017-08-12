package com.hzzh.demo

import android.arch.lifecycle.LiveData
import com.hzzh.baselibrary.model.UserModel
import com.hzzh.baselibrary.net.BaseResponse
import com.hzzh.baselibrary.net.DataRepository
import com.hzzh.baselibrary.net.transformer.DefaultTransformer

/**
 * Created by dmx on 2017/8/12.
 */
class UserLiveData : LiveData<UserModel>() {
    val api = DataRepository.instance.getService(Api::class.java)
    fun login(name: String, password: String) {
        api.login(name, password).compose(DefaultTransformer<BaseResponse<UserModel>, UserModel>()).subscribe({
            userModel ->
            this.value = userModel
        }, {
            exception ->
            exception.printStackTrace()
            this.value = null
        })
    }
}