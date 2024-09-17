package dtos

import java.time.Instant

data class SubTopicoDTO(

    val nome: String,
    val descricao: String,
    val topico_id: Int,
    val criacao: Instant = Instant.now(),
    val ativo: Boolean
)
