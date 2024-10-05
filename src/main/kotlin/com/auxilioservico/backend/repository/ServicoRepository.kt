package com.auxilioservico.backend.repository

import com.auxilioservico.backend.model.Pesquisa
import com.auxilioservico.backend.model.Servico
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import java.awt.print.Pageable

interface ServicoRepository: JpaRepository<Servico, Long> {
    fun findById(id: Long, paginacao: org.springframework.data.domain.Pageable): Page<Servico>
}