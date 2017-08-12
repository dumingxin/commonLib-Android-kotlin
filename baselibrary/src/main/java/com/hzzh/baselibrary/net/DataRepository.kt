package com.hzzh.baselibrary.net

import com.google.gson.GsonBuilder
import com.hzzh.baselibrary.constant.ProjectConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

/**
 * Created by dmx on 2017/7/6.
 */

class DataRepository private constructor() {

    var retrofit: Retrofit

    init {
        val builder = Retrofit.Builder()
        builder.baseUrl(ProjectConfig.apiServerAddress)
        builder.client(DefaultOkHttpClient.getTokenOkHttpClient())
        builder.addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        retrofit = builder.build()
    }

    private val serviceCache = HashMap<String, Any>()

    fun <T : Any> getService(service: Class<T>): T {
        var proxy: T? = serviceCache[service.name] as T?
        if (proxy == null) {
            proxy = instance.retrofit.create(service)
            ///TODO 需要处理缓存时，再做一次代理
            //            proxy = (T) Proxy.newProxyInstance(service.getClassLoader(), new Class[]{service}, new InvocationHandler() {
            //                @Override
            //                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //                    return method.invoke(retrofitProxy, args);
            //                }
            //            });
            serviceCache.put(service.name, proxy)
        }
        return proxy!!
    }

    companion object {
        @JvmStatic val instance = DataRepository()
    }

}