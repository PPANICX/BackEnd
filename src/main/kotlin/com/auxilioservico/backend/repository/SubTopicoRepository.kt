package com.auxilioservico.backend.repository

import com.auxilioservico.backend.model.Pesquisa
import com.auxilioservico.backend.model.SubTopico
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import java.awt.print.Pageable


interface SubTopicoRepository: JpaRepository<SubTopico, Long> {

    fun findById(id: Long, paginacao: org.springframework.data.domain.Pageable): Page<SubTopico>
}