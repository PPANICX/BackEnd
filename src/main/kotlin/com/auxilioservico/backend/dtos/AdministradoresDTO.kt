package com.auxilioservico.backend.dtos

import jakarta.validation.constraints.NotEmpty
import java.time.Instant

data class AdministradoresDTO(
    @field:NotEmpty(message = "O Administrador deve ter um Nome")
    val nome: String,
    @field:NotEmpty(message = "O Administrador deve ter um Email")
    val email: String,
    @field:NotEmpty(message = "O Administardor deve ter uma Senha")
    val senha: String,
    @field:NotEmpty(message = "O Administrador deve ter um tipo")
    val tipo: String,
    @field:NotEmpty(message = "O Administrador deve ter uma Data de Criação")
    val criacao: Instant = Instant.now()
)
