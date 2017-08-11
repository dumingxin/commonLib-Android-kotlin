package com.hzzh.baselibrary.constant

/**
 * 常见错误码对应的错误信息
 * Created by dmx on 16/12/1.
 */

object ErrorMessage {
    /**
     * 根据编码获取对应的错误信息，没有对应编码则返回null

     * @param code
     * *
     * @return
     */
    operator fun get(code: String): String? {
        when (code) {
            "InvalidParameter" -> return "参数错误"
            "InvalidUser" -> return "非法的用户账号"

            "ForbiddenAccess" -> return "禁止访问"

            "InvalidSignature" -> return "错误的签名"

            "InvalidTimestamp" -> return "错误的时间戳"

            "ExceedingSLAQuota" -> return "超出SLA限制"

            "OpenAPIInternalError" -> return "开放接口系统内部错误"

            "ServiceUnavailable" -> return "没有可调用的后端业务服务"

            "ServiceError" -> return "未识别的后台业务系统错误"

            "CompanyNameExistsed" -> return "企业名称已经存在"

            "CompanyServiceBackError" -> return "企业服务后台错误"

            "IllegalCharacter" -> return "非法字符"

            "NotHaveData" -> return "没有数据"

            "dtuModelExist" -> return "DTU型号名称重复"

            "modelNameRepeated" -> return "传感器型号名称重复"

            "sensorNameRepeated" -> return "传感器名称重复"

            "dtuNameRepeated" -> return "DTU名称重复"

            "fofbidDeleteStation" -> return "禁止删除站点"

            "InvalidPhoneOrEmail" -> return "无效的手机号或邮箱"

            "UserNotExists" -> return "用户不存在"

            "InvalidUserId" -> return "非法的用户ID"

            "UserAlreadyExists" -> return "用户已存在"

            "InvalidAuthCode" -> return "错误的验证码"

            "AuthCodeOverTime" -> return "验证码过期"

            "AccountHasLocked" -> return "帐号被锁定"

            "NoStationCode" -> return "基站编码为空"

            "CreateFailed" -> return "设置预警电量失败"

            else -> return null
        }
    }
}
