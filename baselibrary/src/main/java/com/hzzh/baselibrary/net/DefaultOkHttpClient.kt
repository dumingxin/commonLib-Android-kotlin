package com.hzzh.baselibrary.net

import com.hzzh.baselibrary.BaseApplication
import com.hzzh.baselibrary.R
import okhttp3.OkHttpClient
import java.security.KeyStore
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

/**
 * Created by dmx on 2017/8/11.
 */
object DefaultOkHttpClient {
    private val DEFAULT_TIME_OUT = 60//默认的超时时间5秒钟

    private val PASSWD = "pw1234";

    private var token = ""

    fun setToken(token: String) {
        this.token = token
    }

    fun getTokenOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(DEFAULT_TIME_OUT.toLong(), TimeUnit.SECONDS)
        builder.readTimeout(DEFAULT_TIME_OUT.toLong(), TimeUnit.SECONDS)
        builder.writeTimeout(DEFAULT_TIME_OUT.toLong(), TimeUnit.SECONDS)
        //请求头里面添加token
        builder.addInterceptor { chain ->
            val authorised = chain.request().newBuilder()
                    .header("Authorization", "Bearer " + token)
                    .build()
            chain.proceed(authorised)
        }
//        setCertificates(builder)
        val client = builder.build()
        return client
    }

    private fun setCertificates(builder: OkHttpClient.Builder) {
        try {
            val input = BaseApplication.instance.resources.openRawResource(R.raw.example)
            val trustStore = KeyStore.getInstance(KeyStore
                    .getDefaultType())
            trustStore.load(input, PASSWD.toCharArray())

            val sslContext = SSLContext.getInstance("TLS")

            val x509TrustManager = DefaultX509TrustManager()

            sslContext.init(null, arrayOf<TrustManager>(x509TrustManager), SecureRandom())
            builder.sslSocketFactory(sslContext.socketFactory, x509TrustManager)


        } catch (e: Exception) {
            e.printStackTrace()
        }

    }


    class DefaultX509TrustManager : X509TrustManager {

        @Throws(CertificateException::class)
        override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {

        }

        @Throws(CertificateException::class)
        override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {

        }

        override fun getAcceptedIssuers(): Array<X509Certificate> {
            throw  UnsupportedOperationException()
        }
    }
}