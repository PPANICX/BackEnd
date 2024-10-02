package com.auxilioservico.backend.dtos

import java.time.Instant

data class PesquisaResponseDTO(
    val id: Long? = null,
    val data: String = Instant.now().toString(),
    val servico_id: String

)
