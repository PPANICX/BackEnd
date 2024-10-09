package com.auxilioservico.backend.dtos

import java.util.*

data class TopicoResponseDTO(

    val id: Long? = null,
    val nome: String,
    val descricao: String,
    val criacao: Date,
    val ativo: Boolean
)
