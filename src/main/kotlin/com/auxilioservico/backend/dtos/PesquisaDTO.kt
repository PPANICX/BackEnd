package com.auxilioservico.backend.dtos

import com.auxilioservico.backend.model.Servico
import jakarta.validation.constraints.NotEmpty
import java.time.Instant
import java.util.Date

data class PesquisaDTO(
    @field:NotEmpty(message = "A pesquisa deve gravar datas")
    val data: Date,
    @field:NotEmpty(message = "A pesquisa deve estar relacionada aos ID's")
    val servico: Servico
)
