package com.auxilioservico.backend.dtos

import com.auxilioservico.backend.model.Servico
import java.time.Instant

data class ProblemaResponseDTO(

    val id: Long? = null,
    val servico: Servico,
    val descricao: String,
    val status: String,
    val criacao: Instant = Instant.now(),
    val resolucao: String
)
