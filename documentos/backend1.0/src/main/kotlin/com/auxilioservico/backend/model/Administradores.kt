package com.auxilioservico.backend.model

import jakarta.persistence.*

@Entity
data class Administradores (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val email: String,
    val senha: String,
    val tipo: String,
    val criacao: String

)