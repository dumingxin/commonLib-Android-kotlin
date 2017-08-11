package com.hzzh.baselibrary.net.transformer


import com.hzzh.baselibrary.net.BaseResponse
import com.hzzh.baselibrary.net.RetryWhenNetworkException

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer

/**
 * Created by dmx on 16/12/1.
 */
class DefaultTransformer<T : BaseResponse<R>, R> : ObservableTransformer<T, R> {

    override fun apply(upstream: Observable<T>): ObservableSource<R> {
        return upstream
                .compose(SchedulerTransformer<T>())
                .compose(ErrorCheckerTransformer<T, R>())
                .retryWhen(RetryWhenNetworkException(2, 1000))
    }
}