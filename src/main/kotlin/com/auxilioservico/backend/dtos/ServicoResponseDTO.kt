package com.auxilioservico.backend.dtos

import com.auxilioservico.backend.model.SubTopico
import java.util.*

data class ServicoResponseDTO(

    val id: Long? = null,
    val nome: String,
    val brevedesc: String,
    val descricao: String,
    val imagem: String,
    val apiref: String,
    val apilocal: String,
    val subTopico: SubTopico,
    val ativo: Boolean,
    val criacao: Date
)
