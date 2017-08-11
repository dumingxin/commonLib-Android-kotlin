package com.hzzh.baselibrary.net.transformer


import com.hzzh.baselibrary.constant.ErrorMessage
import com.hzzh.baselibrary.exception.InvalidTimestampException
import com.hzzh.baselibrary.exception.OpenAPIException
import com.hzzh.baselibrary.net.BaseResponse

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.exceptions.Exceptions
import io.reactivex.functions.Function

/**
 * 错误分为两类，一类是正常返回错误码的，一类是http请求的错误
 * Created by dmx on 16/12/1.
 */

class ErrorCheckerTransformer<T : BaseResponse<R>, R> : ObservableTransformer<T, R> {


    override fun apply(upstream: Observable<T>): ObservableSource<R> {
        return upstream.map(Function<T, R> { t ->
            try {
                if (t != null) {
                    val code = t.code
                    if (code == null) {
                        if (t.data != null) {
                            return@Function t.data
                        } else {
                            return@Function t.dataList
                        }

                    } else {
                        if (code == "InvalidTimestamp") {
                            throw InvalidTimestampException()
                        } else {
                            val message = ErrorMessage[code]
                            if (message != null) {
                                throw OpenAPIException(code, message)
                            } else {
                                throw OpenAPIException(code, t.message!!)
                            }
                        }

                    }
                } else {
                    return@Function null
                }
            } catch (ex: Exception) {
                if (ex is RuntimeException) {
                    throw ex
                } else {
                    throw Exceptions.propagate(ex)
                }
            }
        })
    }
}
