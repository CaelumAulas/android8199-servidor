package br.com.caelum.twittelumappweb.modelo

data class Tweet(val mensagem: String,
                 val foto: String?,
                 val dono: Usuario,
                 val longitude: Double,
                 val latitude: Double,
                 val id: Long = 0) {

    override fun toString(): String {
        return mensagem
    }

}