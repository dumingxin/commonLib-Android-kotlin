package com.hzzh.baselibrary.exception

/**
 * OpenAPI定义的错误格式
 * Created by dmx on 2016/12/7.
 */

open class OpenAPIException : RuntimeException {
    var code: String? = null


    constructor(message: String) : super(message) {}

    constructor(code: String, message: String) : super(message) {
        this.code = code
    }
}
