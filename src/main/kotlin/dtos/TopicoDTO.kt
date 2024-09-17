package dtos

import java.time.Instant

data class TopicoDTO(

    val nome: String,
    val descricao: String,
    val criacao: Instant = Instant.now(),
    val ativo: Boolean
)
