package com.hzzh.demo

import com.hzzh.baselibrary.model.UserModel
import com.hzzh.baselibrary.net.BaseResponse
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by dmx on 2017/8/11.
 */
interface Api {
    /**
     * 登录接口

     * @param user
     * *
     * @param password
     * *
     * @return
     */
    @FormUrlEncoded
    @POST("user/login")
    fun login(@Field("user") user: String, @Field("password") password: String): Observable<BaseResponse<UserModel>>

}