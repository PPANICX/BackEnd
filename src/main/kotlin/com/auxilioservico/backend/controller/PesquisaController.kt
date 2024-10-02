package com.auxilioservico.backend.controller

import com.auxilioservico.backend.dtos.PesquisaResponseDTO
import com.auxilioservico.backend.service.PesquisaService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pesquisa")
class PesquisaController (private val service: PesquisaService){

    @GetMapping
    fun listar():List<PesquisaResponseDTO> {
        return service.listar()
    }


}