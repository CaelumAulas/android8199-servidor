package br.com.caelum.twittelumappweb.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import br.com.caelum.twittelumappweb.modelo.Usuario
import br.com.caelum.twittelumappweb.webservice.UsuarioWebClient

class UsuarioRepository(private val webClient: UsuarioWebClient) {
    val usuarioEstaLogado: MutableLiveData<Boolean> = MutableLiveData()
    val usuarioDaSessao: MutableLiveData<Usuario> = MutableLiveData()

    fun registra(usuario: Usuario) {
        webClient.registra(usuario, sucesso())
    }


    fun fazLogin(usuario: Usuario) {
        webClient.fazLogin(usuario, sucesso())
    }


    private fun sucesso() = { usuario: Usuario ->
        usuarioEstaLogado.value = true
        usuarioDaSessao.value = usuario
    }
}
