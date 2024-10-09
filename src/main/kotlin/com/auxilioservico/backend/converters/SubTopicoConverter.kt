package com.auxilioservico.backend.converters

import com.auxilioservico.backend.dtos.SubTopicoResponseDTO
import com.auxilioservico.backend.model.SubTopico
import org.springframework.stereotype.Component


@Component
class SubTopicoConverter {

    fun toSubTopico(dto: com.auxilioservico.backend.dtos.SubTopicoDTO): SubTopico{
        return SubTopico(
            nome = dto.nome,
            descricao = dto.descricao,
            topico = dto.topico,
            criacao = dto.criacao,
            ativo = dto.ativo
        )
    }

    fun toSubtopicoResponseDTO(subtopico: SubTopico): SubTopicoResponseDTO{
        return SubTopicoResponseDTO(
            id = subtopico.id,
            nome = subtopico.nome,
            descricao = subtopico.descricao,
            topico = subtopico.topico,
            criacao = subtopico.criacao,
            ativo = subtopico.ativo

        )
    }
}