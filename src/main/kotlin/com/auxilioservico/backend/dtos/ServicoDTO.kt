package com.auxilioservico.backend.dtos

import javax.validation.constraints.NotEmpty

data class ServicoDTO(
    @field:NotEmpty(message = "O Serviço deve ter um Nome")
    val nome: String,
    @field:NotEmpty(message = "O Serviço deve ter uma Breve Descrição")
    val brevedesc: String,
    @field:NotEmpty(message = "O Serviço deve ter uma Descrição")
    val descricao: String,
    @field:NotEmpty(message = "O Serviço deve ter ao menos uma Imagem")
    val imagem: String,
    val apiref: String,
    @field:NotEmpty(message = "O Serviço deve ter ao menos uma Localização")
    val apilocal: String

)
