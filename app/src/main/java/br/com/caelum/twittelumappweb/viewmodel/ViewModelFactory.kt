package br.com.caelum.twittelumappweb.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.caelum.twittelumappweb.data.TweetRepository
import br.com.caelum.twittelumappweb.data.UsuarioRepository
import br.com.caelum.twittelumappweb.webservice.UsuarioWebClient

object ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    private fun tweetRepository() = TweetRepository()
    private fun usuarioRepository() = UsuarioRepository(UsuarioWebClient())

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T  {
        when(modelClass) {
            TweetViewModel::class.java -> {
                return TweetViewModel(tweetRepository()) as T
            }
            else -> {
                return UsuarioViewModel(usuarioRepository()) as T
            }
        }
    }


}