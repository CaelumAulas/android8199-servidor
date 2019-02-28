package br.com.caelum.twittelumappweb.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.fragment.BuscaTweetFragment
import br.com.caelum.twittelumappweb.fragment.ListaTweetsFragment
import br.com.caelum.twittelumappweb.fragment.MapaFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listenerBottomNavigation()

        botao_fab.setOnClickListener {
            val intent = Intent(this, TweetActivity::class.java)
            startActivity(intent)
        }

        bottom_navigation.selectedItemId = R.id.menu_tweets
    }

    private fun listenerBottomNavigation() {
        bottom_navigation.setOnNavigationItemSelectedListener {item ->
            when(item.itemId) {
                R.id.menu_tweets -> {
                    exibe(ListaTweetsFragment())
                    true
                }
                R.id.menu_busca -> {
                    exibe(BuscaTweetFragment())
                    true
                }
                R.id.menu_mapa -> {
                    exibe(MapaFragment())
                    true
                }
                else ->  true
            }
        }
    }

    private fun exibe(fragmento: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_principal,fragmento)
        transaction.commit()
    }
}
