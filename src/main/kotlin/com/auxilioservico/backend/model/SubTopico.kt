package com.auxilioservico.backend.model

import jakarta.persistence.*
import java.util.*


@Entity
data class SubTopico (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val descricao: String,
    @ManyToOne
    val topico: Topico,
    val criacao: Date,
    val ativo: Boolean

)