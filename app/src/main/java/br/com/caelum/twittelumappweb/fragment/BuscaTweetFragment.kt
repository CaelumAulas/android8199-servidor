package br.com.caelum.twittelumappweb.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.SearchView
import android.view.*
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.adapter.TweetAdapter
import br.com.caelum.twittelumappweb.viewmodel.TweetViewModel
import br.com.caelum.twittelumappweb.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_lista_tweets.*
import kotlinx.android.synthetic.main.fragment_lista_tweets.view.*

class BuscaTweetFragment : Fragment() {
    val viewModel: TweetViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory).get(TweetViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_lista_tweets, container, false)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.busca_menu, menu)

        val item = menu?.findItem(R.id.barra_busca)

        val busca = item?.actionView as SearchView


        busca.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(texto: String?): Boolean {
                if (!texto.isNullOrEmpty()) {
                    val tweets = viewModel.tweets()


                    val tweetsFiltrados = tweets.filter { tweet -> tweet.mensagem.contains(texto!!) }


                    val adapter = TweetAdapter(tweetsFiltrados)

                    lista_tweets.adapter = adapter
                }
                return false
            }

            override fun onQueryTextChange(texto: String?): Boolean {
                return false
            }

        })













    }

}