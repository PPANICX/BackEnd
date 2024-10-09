package com.auxilioservico.backend.dtos

import com.auxilioservico.backend.model.Servico
import jakarta.validation.constraints.NotEmpty
import java.time.Instant

data class ProblemaDTO (
    @field:NotEmpty(message = "O problema deve estar relacionado a um serviço")
    val servico: Servico,
    @field:NotEmpty(message = "O problema deve ter uma descrição")
    val descricao: String,
    @field:NotEmpty(message = "O problema deve ter um status")
    val status: String,
    @field:NotEmpty(message = "O problema deve conter uma data de criação")
    val criacao: Instant = Instant.now(),
    @field:NotEmpty(message = "O problema deve ter uma ")
    val resolucao: String
)