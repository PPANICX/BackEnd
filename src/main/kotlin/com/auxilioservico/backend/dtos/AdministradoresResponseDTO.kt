package com.auxilioservico.backend.dtos

import java.time.Instant

data class AdministradoresResponseDTO(

    val id: Long? = null,
    val nome: String,
    val email: String,
    val senha: String,
    val tipo: String,
    val criacao: String = Instant.now().toString()
)
