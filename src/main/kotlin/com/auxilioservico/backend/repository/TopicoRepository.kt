package com.auxilioservico.backend.repository

import com.auxilioservico.backend.model.Topico
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository: JpaRepository<Topico, Long> {

    fun findById(id: Long, paginacao: org.springframework.data.domain.Pageable): Page<Topico>

}