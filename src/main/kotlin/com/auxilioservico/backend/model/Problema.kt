package com.auxilioservico.backend.model

import jakarta.persistence.*
import java.time.Instant


@Entity
data class Problema (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne
    val servico: Servico,
    val descricao: String,
    val status: String,
    val criacao: Instant = Instant.now(),
    val resolucao: String
)