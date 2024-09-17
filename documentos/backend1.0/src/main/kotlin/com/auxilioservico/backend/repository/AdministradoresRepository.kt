package com.auxilioservico.backend.repository

import com.auxilioservico.backend.model.Administradores
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface AdministradoresRepository: JpaRepository<Administradores,Long> {
    fun findByNome(nomeAdministradores: String, paginacao: Pageable): Page<Administradores>
}