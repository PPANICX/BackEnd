package com.auxilioservico.backend.controller

import com.auxilioservico.backend.dtos.AdministradoresDTO
import com.auxilioservico.backend.dtos.AdministradoresResponseDTO
import com.auxilioservico.backend.service.AdministradoresService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder



@RestController
@RequestMapping("/administradores")
class AdministradoresController (private val service: AdministradoresService) {

    @GetMapping
    fun listar():List<AdministradoresResponseDTO>{
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): AdministradoresResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid dto: AdministradoresDTO,
                  uriBuider: UriComponentsBuilder
    ):  ResponseEntity<AdministradoresResponseDTO> {
        val administradoresResponse = service.cadastrar(dto)
        val uri = uriBuider.path("/administradores/${administradoresResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(administradoresResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @Valid dto: AdministradoresDTO
    ):  AdministradoresResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}
//mano