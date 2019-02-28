package br.com.caelum.twittelumappweb.webservice

import android.util.Log
import br.com.caelum.twittelumappweb.modelo.Tweet
import br.com.caelum.twittelumappweb.modelo.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

class TweetWebClient(retrofit: Retrofit) {
    private val service = retrofit.create(TweetService::class.java)

    fun salva(tweet: Tweet,
              reqFoiSucesso: (Tweet) -> Unit) {
        service.salva(tweet).enqueue(object : Callback<Tweet> {
            override fun onFailure(call: Call<Tweet>, t: Throwable) {
                Log.i("TWEET", "erro: "+t.message)

            }
            override fun onResponse(call: Call<Tweet>, response: Response<Tweet>) {
                if (response.isSuccessful) {
                    response.body()?.let { tweetDoServidor ->
                        reqFoiSucesso(tweetDoServidor)
                    }
                }
            }
        })
    }

    fun busca(reqFoiSucesso: (List<Tweet>) -> Unit) {
        service.lista().enqueue(object : Callback<List<Tweet>> {
            override fun onFailure(call: Call<List<Tweet>>, t: Throwable) {
                Log.i("TWEET", "erro: "+t.message)

            }
            override fun onResponse(call: Call<List<Tweet>>, response: Response<List<Tweet>>) {
                response.body()?.let {tweets ->
                    reqFoiSucesso(tweets)
                }
            }
        })
    }

}

private interface TweetService {
    @POST("/tweet")
    fun salva(@Body tweet: Tweet): Call<Tweet>

    @GET("/tweet")
    fun lista(): Call<List<Tweet>>
}