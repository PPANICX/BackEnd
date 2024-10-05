package com.auxilioservico.backend.controller

import com.auxilioservico.backend.dtos.TopicoDTO
import com.auxilioservico.backend.dtos.TopicoResponseDTO
import com.auxilioservico.backend.model.Topico
import com.auxilioservico.backend.service.TopicoService
import jakarta.transaction.Transactional
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriBuilder
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid


@RestController
@RequestMapping("/Topicos")
class TopicoController (private val service: TopicoService) {

    @GetMapping
    fun listar(): List<TopicoResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(
        @RequestBody @Valid dto: TopicoDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicoResponseDTO> {
        val topicoResponse = service.cadastar(dto)
        val uri = uriBuilder.path("/topicos/${topicoResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(topicoResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @jakarta.validation.Valid dto: TopicoDTO
    ): TopicoResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }

}