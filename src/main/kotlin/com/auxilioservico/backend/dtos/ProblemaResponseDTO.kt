package com.auxilioservico.backend.dtos

import java.time.Instant

data class ProblemaResponseDTO(

    val id: Long? = null,
    val servico_id: Int,
    val descricao: String,
    val status: String,
    val criacao: Instant = Instant.now(),
    val resolucao: String
)
