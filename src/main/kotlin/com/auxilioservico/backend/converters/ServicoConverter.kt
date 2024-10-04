package com.auxilioservico.backend.converters

import com.auxilioservico.backend.dtos.ServicoResponseDTO
import com.auxilioservico.backend.model.Servico
import org.springframework.stereotype.Component

@Component
class ServicoConverter {

    fun toServico(dto: com.auxilioservico.backend.dtos.ServicoDTO): Servico {
        return Servico(
            nome = dto.nome,
            brevedesc = dto.brevedesc,
            descricao = dto.descricao,
            imagem = dto.imagem,
            apiref = dto.apiref,
            apilocal = dto.apilocal

        )
    }

    fun toServicoResponseDTO(servico: Servico): ServicoResponseDTO{
        return ServicoResponseDTO(
            id = servico.id,
            nome = servico.nome,
            descricao = servico.descricao,
            brevedesc = servico.brevedesc,
            imagem = servico.imagem,
            apiref = servico.apiref,
            apilocal = servico.apilocal
        )
    }

}