package br.com.caelum.twittelumappweb.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.caelum.twittelumappweb.data.TweetRepository
import br.com.caelum.twittelumappweb.data.UsuarioRepository
import br.com.caelum.twittelumappweb.webservice.InicializadorDeRetrofit
import br.com.caelum.twittelumappweb.webservice.TweetWebClient
import br.com.caelum.twittelumappweb.webservice.UsuarioWebClient

object ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T  {
        when(modelClass) {
            TweetViewModel::class.java -> {
                return TweetViewModel(Injetor.tweetRepository) as T
            }
            else -> {
                return UsuarioViewModel(Injetor.usuarioRepository) as T
            }
        }
    }


}

object Injetor {
    val retrofit = InicializadorDeRetrofit.retrofit
     val tweetRepository = TweetRepository(TweetWebClient(retrofit))
     val usuarioRepository = UsuarioRepository(UsuarioWebClient(retrofit))

}