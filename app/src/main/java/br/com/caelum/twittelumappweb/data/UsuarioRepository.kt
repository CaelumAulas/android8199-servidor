package br.com.caelum.twittelumappweb.data

import android.util.Log
import br.com.caelum.twittelumappweb.modelo.Usuario

class UsuarioRepository {
    fun registra(usuario: Usuario) {
        Log.i("LOGIN", "${usuario} criado")
    }

    fun fazLogin(usuario: Usuario) {
        Log.i("LOGIN", "${usuario} logado")
    }

}
