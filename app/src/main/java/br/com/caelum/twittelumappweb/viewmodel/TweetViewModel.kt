package br.com.caelum.twittelumappweb.viewmodel

import android.arch.lifecycle.ViewModel
import br.com.caelum.twittelumappweb.data.TweetRepository
import br.com.caelum.twittelumappweb.modelo.Tweet

class TweetViewModel(private val repository: TweetRepository) : ViewModel() {


    fun salva(tweet: Tweet) = repository.salva(tweet)

    fun tweets(): List<Tweet> = listOf(
            Tweet("tweet 1", null),
            Tweet("tweet 2",null),
            Tweet("tweet 3",null),
            Tweet("tweet 4",null)
            )

}