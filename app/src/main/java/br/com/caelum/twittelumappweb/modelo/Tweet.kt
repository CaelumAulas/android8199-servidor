package br.com.caelum.twittelumappweb.modelo

data class Tweet(val mensagem: String,
                 val foto: String?,
                 val dono: Usuario,
                 val id: Long = 0) {

    override fun toString(): String {
        return mensagem
    }

}