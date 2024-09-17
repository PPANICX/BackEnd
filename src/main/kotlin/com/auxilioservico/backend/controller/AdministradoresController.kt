package com.auxilioservico.backend.controller

import com.auxilioservico.backend.dtos.AdministradoresResponseDTO
import com.auxilioservico.backend.service.AdministradoresService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/administradores")
class AdministradoresController (private val service: AdministradoresService) {

    @GetMapping
    fun listar():List<AdministradoresResponseDTO>{
        return service.listar()
    }
}