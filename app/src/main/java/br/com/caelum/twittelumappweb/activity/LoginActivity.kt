package br.com.caelum.twittelumappweb.activity

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.modelo.Usuario
import br.com.caelum.twittelumappweb.viewmodel.TweetViewModel
import br.com.caelum.twittelumappweb.viewmodel.UsuarioViewModel
import br.com.caelum.twittelumappweb.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    val viewModel : UsuarioViewModel by lazy{
        ViewModelProviders.of(this, ViewModelFactory).get(UsuarioViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        botao_cria.setOnClickListener { viewModel.cria(pegaUsuarioDaTela()) }

        botao_loga.setOnClickListener { viewModel.loga(pegaUsuarioDaTela()) }

    }








    private fun pegaUsuarioDaTela(): Usuario {
        val nome = login_nome.text.toString()
        val username = login_username.text.toString()
        val senha = login_senha.text.toString()

        val usuario = Usuario(nome, username, senha)
        return usuario
    }
}
