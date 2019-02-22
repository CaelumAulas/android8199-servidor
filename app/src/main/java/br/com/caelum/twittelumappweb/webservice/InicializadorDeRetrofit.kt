package br.com.caelum.twittelumappweb.webservice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InicializadorDeRetrofit {

    val retrofit = Retrofit.Builder()
            .baseUrl("https://e192a043.ngrok.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}