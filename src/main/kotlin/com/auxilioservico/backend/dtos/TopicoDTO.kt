package com.auxilioservico.backend.dtos

import javax.validation.constraints.NotEmpty

data class TopicoDTO(
    @field:NotEmpty(message = "O Topico tem que ter um Nome")
    val nome: String,
    val subtop: String
)
