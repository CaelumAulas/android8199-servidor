package br.com.caelum.twittelumappweb.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.adapter.TweetAdapter
import br.com.caelum.twittelumappweb.modelo.Tweet
import br.com.caelum.twittelumappweb.viewmodel.TweetViewModel
import br.com.caelum.twittelumappweb.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_lista_tweets.view.*

class ListaTweetsFragment : Fragment() {
    val viewModel: TweetViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory).get(TweetViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_lista_tweets, container, false)

        viewModel.tweets().observe(this, Observer {tweets ->

            view.swipe.isRefreshing = false
            val adapter = TweetAdapter(tweets!!)

            view.lista_tweets.adapter = adapter
        })


        view.swipe.setOnRefreshListener {
            viewModel.tweets()
        }

        view.swipe.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.RED)

        return view
    }
}