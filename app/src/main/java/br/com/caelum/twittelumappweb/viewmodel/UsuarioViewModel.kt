package br.com.caelum.twittelumappweb.viewmodel

import android.arch.lifecycle.ViewModel
import br.com.caelum.twittelumappweb.data.UsuarioRepository
import br.com.caelum.twittelumappweb.modelo.Usuario

class UsuarioViewModel(private val usuarioRepository: UsuarioRepository) : ViewModel() {

    fun cria(usuario: Usuario) {
        usuarioRepository.registra(usuario)
    }

    fun loga(usuario: Usuario) {
        usuarioRepository.fazLogin(usuario)
    }

    fun usuarioEstaLogado() = usuarioRepository.usuarioEstaLogado
    fun usuarioDaSessao() = usuarioRepository.usuarioDaSessao

}
