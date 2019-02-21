package br.com.caelum.twittelumappweb.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.fragment.ListaTweetsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listenerBottomNavigation()
    }

    private fun listenerBottomNavigation() {
        bottom_navigation.setOnNavigationItemSelectedListener {item ->
            when(item.itemId) {
                R.id.menu_tweets -> {
                    exibe()
                    true
                }
                else ->  true
            }
        }
    }

    private fun exibe() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_principal,ListaTweetsFragment())
        transaction.commit()
    }
}
