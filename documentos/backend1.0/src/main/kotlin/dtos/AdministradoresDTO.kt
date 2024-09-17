package dtos

import java.time.Instant

data class AdministradoresDTO(
    val nome: String,
    val email: String,
    val senha: String,
    val tipo: String,
    val criacao: Instant = Instant.now()
)
