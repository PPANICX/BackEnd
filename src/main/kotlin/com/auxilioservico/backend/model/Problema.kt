package com.auxilioservico.backend.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.Instant


@Entity
data class Problema (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val servico_id: Int,
    val descricao: String,
    val status: String,
    val criacao: Instant = Instant.now(),
    val resolucao: String
)