package com.auxilioservico.backend.repository

import com.auxilioservico.backend.model.Pesquisa
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import java.awt.print.Pageable

interface PesquisaRepository: JpaRepository<Pesquisa, Long> {
    fun findByNome(idPesquisa: Int, paginacao: Pageable): Page<Pesquisa> }