package com.auxilioservico.backend.converters

import com.auxilioservico.backend.dtos.TopicoResponseDTO
import com.auxilioservico.backend.model.Topico
import org.springframework.stereotype.Component

@Component
class TopicoConverter {

    fun toTopico(dto: com.auxilioservico.backend.dtos.TopicoDTO): Topico {
        return Topico(
            nome = dto.nome,
            subtop = dto.subtop
        )

    }

    fun toTopicoResponseDTO(topico: Topico): TopicoResponseDTO{
        return TopicoResponseDTO(
            id = topico.id,
            nome = topico.nome,
            subtop = topico.subtop
        )
    }
}