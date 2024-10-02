package com.auxilioservico.backend.service

import com.auxilioservico.backend.converters.ProblemaConverter
import com.auxilioservico.backend.dtos.ProblemaDTO
import com.auxilioservico.backend.dtos.ProblemaResponseDTO
import com.auxilioservico.backend.exceptions.NotFoundException
import com.auxilioservico.backend.repository.ProblemaRepository
import org.springframework.stereotype.Service

private const val PROBLEMA_NOT_FOUND_MESSAGE = "O Relatorio não foi encontrado"

@Service
class ProblemaService (private val repository: ProblemaRepository,
                        val converter: ProblemaConverter){

        fun listar(): List<ProblemaResponseDTO> {
            return repository.findAll().map(converter::toProblemaResponseDTO)
        }

    fun buscarPorId(id: Long): ProblemaResponseDTO{
        val problema = repository
            .findById(id).orElseThrow { NotFoundException(PROBLEMA_NOT_FOUND_MESSAGE) }
        return converter.toProblemaResponseDTO(problema)


    }

    fun cadastrar(dto: ProblemaDTO): ProblemaResponseDTO {
        return converter.toProblemaResponseDTO(
            repository.save(converter.toProblema(dto))
        )
    }

    fun atualizar (id: Long, dto: ProblemaDTO): ProblemaResponseDTO{
        val problema = repository.findById(id)
            .orElseThrow { NotFoundException(PROBLEMA_NOT_FOUND_MESSAGE) }
            .copy(
                descricao = dto.descricao,
                criacao = dto.criacao,
                status = dto.status

            )
        return converter.toProblemaResponseDTO(repository.save(problema))
    }
    fun deletar(id: Long) {
        repository.deleteById(id)
    }

}