package com.auxilioservico.backend.model

import jakarta.persistence.*
import java.time.Instant
import java.util.Date

@Entity
data class Pesquisa(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val data: Date,
    @ManyToOne
    val servico: Servico
)
// idbfuiaehf