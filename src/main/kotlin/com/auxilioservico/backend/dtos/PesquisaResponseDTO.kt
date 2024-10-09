package com.auxilioservico.backend.dtos

import com.auxilioservico.backend.model.Servico
import java.util.Date

data class PesquisaResponseDTO(
    val id: Long? = null,
    val data: Date,
    val servico: Servico

)
