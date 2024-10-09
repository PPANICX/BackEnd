package com.auxilioservico.backend.dtos

import com.auxilioservico.backend.model.Topico
import java.util.Date

data class SubTopicoResponseDTO(

    val id: Long? = null,
    val nome: String,
    val descricao: String,
    val topico: Topico,
    val criacao: Date,
    val ativo: Boolean

)
