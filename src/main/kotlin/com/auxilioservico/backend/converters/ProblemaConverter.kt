package com.auxilioservico.backend.converters

import com.auxilioservico.backend.dtos.ProblemaDTO
import com.auxilioservico.backend.dtos.ProblemaResponseDTO
import com.auxilioservico.backend.model.Problema
import org.springframework.stereotype.Component
import java.time.Instant


@Component
class ProblemaConverter {

    fun toProblema(dto: ProblemaDTO): Problema{
        return Problema(
            servico = dto.servico,
            descricao = dto.descricao,
            status = dto.status,
            criacao = dto.criacao,
            resolucao = dto.resolucao
        )
    }

    fun toProblemaResponseDTO(problema: Problema): ProblemaResponseDTO{
        return ProblemaResponseDTO(
            id = problema.id,
            servico = problema.servico,
            descricao = problema.descricao,
            status = problema.status,
            criacao = problema.criacao,
            resolucao = problema.resolucao,
        )
    }
}