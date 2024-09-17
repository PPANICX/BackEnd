package com.auxilioservico.backend.converters

import com.auxilioservico.backend.dtos.AdministradoresResponseDTO
import com.auxilioservico.backend.model.Administradores
import org.springframework.stereotype.Component


@Component
class AdministradoresConverter {

    fun toAdministrador(dto: com.auxilioservico.backend.dtos.AdministradoresDTO): Administradores {
        return Administradores (
            nome = dto.nome,
            email = dto.email,
            senha = dto.senha,
            tipo = dto.tipo,
            criacao = dto.criacao.toString()
        )
    }

    fun toAdministradorReponseDTO (administrador: Administradores): AdministradoresResponseDTO{
        return AdministradoresResponseDTO(
            id = administrador.id,
            nome = administrador.nome,
            email = administrador.email,
            senha = administrador.senha,
            tipo = administrador.tipo,
            criacao = administrador.criacao
        )
    }
}