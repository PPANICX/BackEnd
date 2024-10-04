package com.auxilioservico.backend.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Servico (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val brevedesc: String,
    val descricao: String,
    val imagem: String,
    val apiref: String,
    val apilocal: String
)