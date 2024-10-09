package com.auxilioservico.backend.dtos

import com.auxilioservico.backend.model.Topico
import java.util.Date
import javax.validation.constraints.NotEmpty

data class SubTopicoDTO(
    @field:NotEmpty(message = "O SubTopico deve ter um Nome")
    val nome: String,
    @field:NotEmpty(message = "O SubTopico deve ter uma breve Descrição")
    val descricao: String,
    val topico: Topico,
    @field:NotEmpty(message = "O SubTopico deve ter uma Data de Criação")
    val criacao: Date,
    val ativo: Boolean
)
