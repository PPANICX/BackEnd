package com.auxilioservico.backend.service

import com.auxilioservico.backend.dtos.SubTopicoResponseDTO
import com.auxilioservico.backend.repository.SubTopicoRepository
import com.auxilioservico.backend.converters.SubTopicoConverter
import com.auxilioservico.backend.dtos.SubTopicoDTO
import com.auxilioservico.backend.exceptions.NotFoundException
import org.springframework.stereotype.Service


private const val SUBTOPICO_NOT_FOUND_MESSAGE = "O SubTopico não foi encontrado!"

@Service
class SubTopicoService(private val repository: SubTopicoRepository,
                        val converter: SubTopicoConverter)   {

    fun listar(): List<SubTopicoResponseDTO> {
        return repository.findAll().map(converter::toSubtopicoResponseDTO)
    }

    fun bucarPorID(id: Long): SubTopicoResponseDTO{
        val subtopico = repository
            .findById(id).orElseThrow { NotFoundException(SUBTOPICO_NOT_FOUND_MESSAGE) }
        return converter.toSubtopicoResponseDTO(subtopico)
    }

    fun cadastrar(dto: SubTopicoDTO): SubTopicoResponseDTO {
        return converter.toSubtopicoResponseDTO(
            repository.save(converter.toSubTopico(dto))
        )
    }

    fun atualizar(id: Long, dto: SubTopicoDTO): SubTopicoResponseDTO {
        val subtopico = repository.findById(id)
            .orElseThrow { NotFoundException(SUBTOPICO_NOT_FOUND_MESSAGE) }
            .copy(
                nome = dto.nome,
                descricao = dto.descricao,
                topico = dto.topico,
                criacao = dto.criacao,
                ativo = dto.ativo
            )
        return converter.toSubtopicoResponseDTO(repository.save(subtopico))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}