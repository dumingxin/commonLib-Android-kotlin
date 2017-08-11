package com.hzzh.baselibrary.net.transformer


import com.hzzh.baselibrary.net.BaseResponse
import com.hzzh.baselibrary.net.RetryWhenNetworkException

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer

/**
 * Created by dmx on 16/12/1.
 */
class OriginalTransformer<T : BaseResponse<*>> : ObservableTransformer<T, T> {

    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream
                .compose(SchedulerTransformer<T>())
                .retryWhen(RetryWhenNetworkException(2, 1000))
    }
}