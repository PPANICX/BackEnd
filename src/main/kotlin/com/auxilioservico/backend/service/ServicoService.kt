package com.auxilioservico.backend.service

import com.auxilioservico.backend.converters.ServicoConverter
import com.auxilioservico.backend.dtos.ServicoDTO
import com.auxilioservico.backend.dtos.ServicoResponseDTO
import com.auxilioservico.backend.exceptions.NotFoundException
import com.auxilioservico.backend.repository.ServicoRepository
import org.springframework.stereotype.Service


private const val SERVICO_NOT_FOUND_MESSAGE = "O Serviço não foi encontrado"

@Service
class ServicoService (private val repository: ServicoRepository,
                      val converter: com.auxilioservico.backend.converters.ServicoConverter
) {

    fun listar(): List<ServicoResponseDTO> {
        return repository.findAll().map(converter::toServicoResponseDTO)
    }

    fun buscarPorId(id: Long): ServicoResponseDTO{
        val servico = repository
            .findById(id).orElseThrow {NotFoundException(SERVICO_NOT_FOUND_MESSAGE)}
        return converter.toServicoResponseDTO(servico)
    }

    fun cadastrar(dto: ServicoDTO): ServicoResponseDTO {
        return converter.toServicoResponseDTO(
            repository.save(converter.toServico(dto))
        )
    }

    fun atualizar(id: Long, dto: ServicoDTO): ServicoResponseDTO{
        val servico = repository.findById(id)
            .orElseThrow { NotFoundException(SERVICO_NOT_FOUND_MESSAGE) }
            .copy(
                nome = dto.nome,
                brevedesc = dto.brevedesc,
                descricao = dto.descricao,
                imagem = dto.imagem,
                apiref = dto.apiref,
                apilocal = dto.apilocal,
                subTopico = dto.subTopico,
                ativo = dto.ativo,
                criacao = dto.criacao
            )
        return converter.toServicoResponseDTO(repository.save(servico))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}