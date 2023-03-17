package com.andrescoulson.shoppingcart.core

import com.andrescoulson.shoppingcart.BuildConfig.API_KEY
import com.andrescoulson.shoppingcart.BuildConfig.BEARER_TOKEN
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

private const val APIKEY = "api_key"

class AuthInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestURL = request.url.newBuilder().addQueryParameter(APIKEY, API_KEY).build()
        val newURL = request.newBuilder().url(requestURL).build()
        return chain.proceed(newURL)
    }
}