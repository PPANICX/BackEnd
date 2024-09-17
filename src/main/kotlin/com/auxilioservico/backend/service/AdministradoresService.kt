package com.auxilioservico.backend.service

import com.auxilioservico.backend.converters.AdministradoresConverter
import com.auxilioservico.backend.dtos.AdministradoresDTO
import com.auxilioservico.backend.dtos.AdministradoresResponseDTO
import com.auxilioservico.backend.exceptions.NotFoundException
import com.auxilioservico.backend.repository.AdministradoresRepository
import org.springframework.stereotype.Service

private const val ADMINISTRADORES_NOT_FOUND_MESSAGE ="Administrador não encontrado"

@Service
class AdministradoresService (private val repository: AdministradoresRepository,
                                val converter: AdministradoresConverter
){
    fun listar(): List<AdministradoresResponseDTO> {
        return repository.findAll().map(converter::toAdministradorReponseDTO)
    }
    fun buscarPorId(id: Long): AdministradoresResponseDTO{
        val administrador = repository
            .findById(id).orElseThrow { NotFoundException(ADMINISTRADORES_NOT_FOUND_MESSAGE) }
        return converter.toAdministradorReponseDTO(administrador)
    }

    fun cadastrar(dto: AdministradoresDTO): AdministradoresResponseDTO{
        return converter.toAdministradorReponseDTO(
            repository.save(converter.toAdministrador(dto))
        )
    }

    fun atualizar(id: Long, dto: AdministradoresDTO): AdministradoresResponseDTO{
        val administradores = repository.findById(id)
            .orElseThrow { NotFoundException(ADMINISTRADORES_NOT_FOUND_MESSAGE) }
            .copy(
                nome = dto.nome,
                email = dto.email,
                senha = dto.senha,
                tipo = dto.tipo,
                criacao = dto.tipo
            )
        return converter.toAdministradorReponseDTO(repository.save(administradores))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}