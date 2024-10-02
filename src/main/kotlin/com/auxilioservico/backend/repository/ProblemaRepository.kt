package com.auxilioservico.backend.repository

import com.auxilioservico.backend.model.Problema
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import java.awt.print.Pageable

interface ProblemaRepository: JpaRepository<Problema, Long> {
    fun findById(idProblema: String, paginacao: Pageable): Page<Problema>
}