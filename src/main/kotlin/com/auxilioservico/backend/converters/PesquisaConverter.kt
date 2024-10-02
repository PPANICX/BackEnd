package com.auxilioservico.backend.converters

import com.auxilioservico.backend.dtos.PesquisaResponseDTO
import com.auxilioservico.backend.model.Pesquisa
import org.springframework.stereotype.Component

@Component
class PesquisaConverter {

    fun toPesquisa(dto: com.auxilioservico.backend.dtos.PesquisaDTO): Pesquisa{
        return Pesquisa(
            data = dto.data.toString(),
            servico_id = dto.servico_id.toString()
        )
    }

    fun toPesquisaResponseDTO(pesquisa: Pesquisa): PesquisaResponseDTO{
        return PesquisaResponseDTO(
            id = pesquisa.id,
            data = pesquisa.data,
            servico_id = pesquisa.servico_id
        )
    }
}