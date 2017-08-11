package com.hzzh.baselibrary.model

import java.io.Serializable

/**
 * Created by wangjiongye on 16/4/18.
 */
class UserModel : Serializable {

    var position: String? = null
    var employeeId: String? = null
    var birthday: String? = null
    var sex: String? = null
    var accountId: String? = null
    var companyName: String? = null
    var telphone: String? = null
    private var employeeName: String? = null
    private var name: String? = null
    var customerId: String? = null
    var email: String? = null
    var cellphone: String? = null
    var wechat: String? = null
    var departmentId: String? = null
    var user: String? = null
    var logo: String? = null
    var token: String? = null
    var icon: String? = null
    var companyCharacter: List<String>? = null
    var isExper: Boolean = false//是否为体验账号

    fun getEmployeeName(): String {
        if (employeeName != null) {
            return employeeName!!
        }
        return name!!
    }

    fun setEmployeeName(employeeName: String) {
        this.employeeName = employeeName
        this.name = employeeName
    }

    fun getName(): String {
        if (name != null) {
            return name!!
        }
        return employeeName!!
    }

    fun setName(name: String) {
        this.name = name
        this.employeeName = name
    }

    var password: String? = null
        get() = ""

    /**
     * 获取个推的别名
     */
    val alias: String
        get() {
            var alias = this.employeeId
            alias = alias!!.replace(":", "")
            alias = alias!!.replace("/", "")
            return alias
        }
}
