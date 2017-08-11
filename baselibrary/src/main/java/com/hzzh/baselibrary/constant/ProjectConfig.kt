package com.hzzh.baselibrary.constant

import android.content.pm.PackageManager
import android.os.Environment
import android.util.Log
import com.hzzh.baselibrary.BaseApplication
import com.hzzh.baselibrary.util.SPUtil
import com.hzzh.baselibrary.util.StringUtil
import java.io.File

/**
 * Created by dmx on 2017/8/11.
 */
object ProjectConfig {

    private val NODEJS_ADDRESS = "NODEJS_ADDRESS"
    private val API_VERSION = "API_VERSION"
    private  var serverAddress: String=""

    fun getServerAddress(): String {
        if (StringUtil.isNullOrEmpty(serverAddress)) {
            serverAddress = SPUtil.getString(ProjectConstant.KEY_SERVER_ADDRESS)
        }
        if (StringUtil.isNullOrEmpty(serverAddress)) {
            serverAddress = getMetaData(NODEJS_ADDRESS)
        }
        return serverAddress
    }

    val apiServerAddress: String
        get() {
            if (StringUtil.isNullOrEmpty(serverAddress)) {
                serverAddress = SPUtil.getString(ProjectConstant.KEY_SERVER_ADDRESS)
            }
            if (StringUtil.isNullOrEmpty(serverAddress)) {
                serverAddress = getMetaData(NODEJS_ADDRESS)
            }
            if (!serverAddress!!.endsWith("/")) {
                serverAddress += "/"
            }
            return serverAddress + "api/" + getMetaData(API_VERSION) + "/"
        }

    val viewServerAddress: String
        get() {
            if (StringUtil.isNullOrEmpty(serverAddress)) {
                serverAddress = SPUtil.getString(ProjectConstant.KEY_SERVER_ADDRESS)
            }
            if (StringUtil.isNullOrEmpty(serverAddress)) {
                serverAddress = getMetaData(NODEJS_ADDRESS)
            }
            if (!serverAddress!!.endsWith("/")) {
                serverAddress += "/"
            }
            return serverAddress + "view/" + getMetaData(API_VERSION) + "/"
        }

    fun setServerAddress(address: String) {
        var address = address
        if (!address.endsWith("/")) {
            address += "/"
        }
        serverAddress = address
        SPUtil.saveString(ProjectConstant.KEY_SERVER_ADDRESS, address)
    }


    private fun getMetaData(key: String): String {
        try {
            val context = BaseApplication.instance
            val appInfo = context.packageManager.getApplicationInfo(context.packageName,
                    PackageManager.GET_META_DATA)
            val value = appInfo.metaData.getString(key)
            Log.d("Tag", key + "  : " + value)
            return value
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }

        return ""
    }

    /**
     * 是否是测试模式
     */
    val DEBUG_MODE = false
    // --------------服务器基本信息-----------------------
    /**
     * 测试的API头地址.
     */
    val DEBUG_HEAD_URL = ""
    /**
     * 产线的API头地址.
     */
    val ONLINE_HEAD_URL = ""
    /**
     * App使用的API头地址.
     */
    val HEAD_URL = if (DEBUG_MODE) DEBUG_HEAD_URL else ONLINE_HEAD_URL
    /**
     * 默认的API头地址.
     */
    val DEBUG_IMAGE_URL = ""
    /**
     * 默认的API头地址.
     */
    val ONLINE_IMAGE_URL = ""
    /**
     * 默认的API头地址.
     */
    val IMAGE_URL = if (DEBUG_MODE) DEBUG_IMAGE_URL else ONLINE_IMAGE_URL
    // --------------应用缓存文件基本信息-----------------------
    /**
     * 程序在手机SDK中的主缓存目录.
     */
    val APP_PATH = Environment.getExternalStorageDirectory().path + File.separator + "CloudEnergy"
    /**
     * 程序在手机SDK中的缓存目录.
     */
    val DIR_CACHE = APP_PATH + File.separator + "cache/"
    /**
     * 程序在手机SDK中的更新缓存目录.
     */
    val DIR_UPDATE = APP_PATH + File.separator + "update/"
    /**
     * 程序在手机SDK中的图片缓存目录.
     */
    val DIR_IMG = APP_PATH + File.separator + "image/"
    /**
     * 程序在手机SDK中的视频缓存目录.
     */
    val DIR_VIDEO = APP_PATH + File.separator + "video/"
    /**
     * 程序在手机SDK中的音频缓存目录.
     */
    val DIR_AUDIO = APP_PATH + File.separator + "audio/"
    /**
     * 程序在手机SDK中的日志缓存目录.
     */
    val LOGCAT_DIR = APP_PATH + File.separator + "Log/"

}