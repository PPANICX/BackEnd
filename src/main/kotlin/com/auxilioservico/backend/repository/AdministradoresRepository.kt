package com.auxilioservico.backend.repository

import com.auxilioservico.backend.model.Administradores
import com.auxilioservico.backend.model.Pesquisa
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface AdministradoresRepository : JpaRepository<Administradores, Long> {
    fun findById(id: Long, paginacao: Pageable): Page<Administradores>
}