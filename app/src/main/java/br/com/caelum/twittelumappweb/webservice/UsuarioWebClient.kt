package br.com.caelum.twittelumappweb.webservice

import android.util.Log
import br.com.caelum.twittelumappweb.modelo.Usuario
import br.com.caelum.twittelumappweb.webservice.InicializadorDeRetrofit.retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

class UsuarioWebClient(retrofit: Retrofit) {

    private val service = retrofit.create(UsuarioService::class.java)

    fun registra(usuario: Usuario,
                 reqFoiSucesso: (usuario: Usuario) -> Unit) {
        service.cria(usuario).enqueue(object : Callback<Usuario> {
            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                Log.i("LOGIN", "erro: "+t.message)
            }

            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                if (response.isSuccessful) {
                    response.body()?.let { usuarioDoServidor ->
                        reqFoiSucesso(usuarioDoServidor)
                    }
                }
            }

        })
    }

    fun fazLogin(usuario: Usuario,
                 reqFoiSucesso: (usuario: Usuario) -> Unit) {
        service.loga(usuario).enqueue(object : Callback<Usuario> {
            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                Log.i("LOGIN", "erro: "+t.message)
            }

            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                if (response.isSuccessful) {
                    response.body()?.let { usuarioDoServidor ->
                        reqFoiSucesso(usuarioDoServidor)
                    }
                }
            }

        })
    }

}

private interface UsuarioService {
    @POST("/usuario")
    fun cria(@Body usuario: Usuario) : Call<Usuario>

    @POST("/usuario/login")
    fun loga(@Body usuario: Usuario): Call<Usuario>

}
