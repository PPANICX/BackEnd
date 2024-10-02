package com.auxilioservico.backend.dtos

import jakarta.validation.constraints.NotEmpty
import java.time.Instant

data class PesquisaDTO(
    @field:NotEmpty(message = "A pesquisa deve gravar datas")
    val data: Instant = Instant.now(),
    @field:NotEmpty(message = "A pesquisa deve estar relacionada aos ID's")
    val servico_id: Int,
)
