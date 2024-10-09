package com.auxilioservico.backend.dtos

import java.util.*
import javax.validation.constraints.NotEmpty

data class TopicoDTO(
    @field:NotEmpty(message = "O Topico tem que ter um Nome")
    val nome: String,
    @field:NotEmpty(message = "O Topico tem que ter uma breve descrição")
    val descricao: String,
    @field:NotEmpty(message = "O Topico deve ter uma Data de Criação")
    val criacao: Date,
    val ativo: Boolean
)
