package com.auxilioservico.backend.controller

import com.auxilioservico.backend.dtos.SubTopicoDTO
import com.auxilioservico.backend.dtos.SubTopicoResponseDTO
import com.auxilioservico.backend.service.SubTopicoService
import jakarta.transaction.Transactional
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
import javax.validation.Valid


@RestController
@RequestMapping("/subtopicos")
class SubTopicoController (private val service: SubTopicoService){

    @GetMapping
    fun listar():List<SubTopicoResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): SubTopicoResponseDTO {
        return service.bucarPorID(id)
    }

    @PostMapping
    fun cadastar(@RequestBody @Valid dto: SubTopicoDTO,
                 uriBuilder: UriComponentsBuilder
    ): ResponseEntity<SubTopicoResponseDTO> {
        val subtopicoResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/subtopicos/${subtopicoResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(subtopicoResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @Valid dto: SubTopicoDTO
    ): SubTopicoResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }

}