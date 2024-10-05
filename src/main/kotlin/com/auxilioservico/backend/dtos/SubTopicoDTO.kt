package com.auxilioservico.backend.dtos

import javax.validation.constraints.NotEmpty

data class SubTopicoDTO(
    @field:NotEmpty(message = "O SubTopico deve ter um Nome")
    val nome: String,
    val servicos: String
)
