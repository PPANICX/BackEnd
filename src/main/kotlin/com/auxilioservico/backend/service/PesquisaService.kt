package com.auxilioservico.backend.service

import com.auxilioservico.backend.dtos.PesquisaResponseDTO
import com.auxilioservico.backend.repository.PesquisaRepository
import org.springframework.stereotype.Service
import com.auxilioservico.backend.converters.PesquisaConverter
import com.auxilioservico.backend.dtos.PesquisaDTO
import com.auxilioservico.backend.exceptions.NotFoundException
import com.auxilioservico.backend.model.Pesquisa


private const val PESQUISA_NOTFOUND_MESSSAGE = "Pesquisa não Pode ser realizada (Erro Interno)"

@Service
class PesquisaService (private val repository: PesquisaRepository,
                       val converter: PesquisaConverter
) {

    fun listar(): List<PesquisaResponseDTO> {
        return repository.findAll().map(converter::toPesquisaResponseDTO)
    }

    fun buscarPorId(id: Long): PesquisaResponseDTO{
        val pesquisa = repository
            .findById(id).orElseThrow { NotFoundException(PESQUISA_NOTFOUND_MESSSAGE) }
        return converter.toPesquisaResponseDTO(pesquisa)
    }

    fun cadastrar(dto: PesquisaDTO): PesquisaResponseDTO {
        return converter.toPesquisaResponseDTO(
            repository.save(converter.toPesquisa(dto))
        )
    }

    fun atualizar(id: Long, dto: PesquisaDTO): PesquisaResponseDTO {
        val pesquisa = repository.findById(id)
            .orElseThrow { NotFoundException(PESQUISA_NOTFOUND_MESSSAGE) }
            .copy(
                data = dto.data.toString(),
                servico_id = dto.servico_id.toString(),
            )
        return converter.toPesquisaResponseDTO(repository.save(pesquisa))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }





}