package dtos

import java.time.Instant
import java.util.Date

data class ProblemasDTO(

    val servico_id: Int,
    val descricao: String,
    val status: String,
    val data_criacão: Instant = Instant.now(),
    val resolucao: String
)
