package com.auxilioservico.backend.repository

import com.auxilioservico.backend.model.Pesquisa
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.domain.Pageable

interface PesquisaRepository : JpaRepository<Pesquisa, Long> {
    fun findById(id: Long, paginacao: Pageable): Page<Pesquisa>
}