package dtos

import java.time.Instant
import java.util.Date

data class ServicoDTO(

    val titulo: String,
    val descricao: String,
    val subtopico: String,
    val imagem: String,
    val links_externos: String,
    val criacao: Instant = Instant.now(),
    val ativo: Boolean
)
