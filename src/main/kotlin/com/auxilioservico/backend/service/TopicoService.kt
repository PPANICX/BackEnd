package com.auxilioservico.backend.service

import com.auxilioservico.backend.dtos.TopicoResponseDTO
import com.auxilioservico.backend.repository.TopicoRepository
import com.auxilioservico.backend.converters.TopicoConverter
import com.auxilioservico.backend.dtos.TopicoDTO
import com.auxilioservico.backend.exceptions.NotFoundException
import org.springframework.stereotype.Service

private const val TOPICO_NOT_FOUND_MESSAGE = "O Topico não foi Encontrado!"

@Service
class TopicoService(private val repository: TopicoRepository,
                    val converter: TopicoConverter) {

    fun listar(): List<TopicoResponseDTO> {
        return repository.findAll().map(converter::toTopicoResponseDTO)
    }

    fun buscarPorId(id: Long): TopicoResponseDTO{
        val topico = repository
            .findById(id).orElseThrow { NotFoundException(TOPICO_NOT_FOUND_MESSAGE) }
            return converter.toTopicoResponseDTO(topico)
    }

    fun cadastar(dto: TopicoDTO): TopicoResponseDTO{
        return converter.toTopicoResponseDTO(
            repository.save(converter.toTopico(dto))
        )
    }

    fun atualizar(id: Long, dto: TopicoDTO): TopicoResponseDTO{
        val topico = repository.findById(id)
            .orElseThrow{ NotFoundException(TOPICO_NOT_FOUND_MESSAGE) }
            .copy(
                nome = dto.nome,
                descricao = dto.descricao,
                criacao = dto.criacao,
                ativo = dto.ativo
            )
        return converter.toTopicoResponseDTO(repository.save(topico))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}