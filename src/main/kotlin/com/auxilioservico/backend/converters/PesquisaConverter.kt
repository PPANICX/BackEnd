package com.auxilioservico.backend.converters

import com.auxilioservico.backend.dtos.PesquisaResponseDTO
import com.auxilioservico.backend.model.Pesquisa
import org.springframework.stereotype.Component

@Component
class PesquisaConverter {

    fun toPesquisa(dto: com.auxilioservico.backend.dtos.PesquisaDTO): Pesquisa{
        return Pesquisa(
            data = dto.data,
            servico = dto.servico
        )
    }

    fun toPesquisaResponseDTO(pesquisa: Pesquisa): PesquisaResponseDTO{
        return PesquisaResponseDTO(
            id = pesquisa.id,
            data = pesquisa.data,
            servico = pesquisa.servico
        )
    }
}