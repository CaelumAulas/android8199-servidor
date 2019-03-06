package br.com.caelum.twittelumappweb.data

import android.arch.lifecycle.MutableLiveData
import br.com.caelum.twittelumappweb.modelo.Tweet
import br.com.caelum.twittelumappweb.webservice.TweetWebClient

class TweetRepository(private val webClient: TweetWebClient) {
    val lista: MutableLiveData<List<Tweet>> = MutableLiveData()

    fun salva(tweet: Tweet) = webClient.salva(tweet, sucessoPraInsercao())

    fun lista(): MutableLiveData<List<Tweet>> {
        if (lista.value == null)
            carregaLista()
        return lista
    }

    fun carregaLista() = webClient.busca(sucessoPraBusca())

    private fun sucessoPraInsercao() = { tweet: Tweet ->
        lista.postValue(lista.value?.let {tweets ->
            val listAtualizada = tweets + tweet
            listAtualizada.sortedByDescending { it.id }
        }) //inserindo o tweet na lista de tweets do mais recente pro mais antigo
    }

    private fun sucessoPraBusca() = {tweets: List<Tweet> ->
        lista.value = tweets
    }

}