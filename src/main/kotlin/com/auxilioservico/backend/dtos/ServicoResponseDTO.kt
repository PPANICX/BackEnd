package com.auxilioservico.backend.dtos

data class ServicoResponseDTO(

    val id: Long? = null,
    val nome: String,
    val brevedesc: String,
    val descricao: String,
    val imagem: String,
    val apiref: String,
    val apilocal: String
)
