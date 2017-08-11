package com.hzzh.baselibrary.net

/**
 * Created by dmx on 16/12/1.
 */

class BaseResponse<T> {
    var code: String? = null
    var message: String? = null
    var data: T? = null
    var dataList: T? = null
}
