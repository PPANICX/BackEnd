package com.auxilioservico.backend.controller

import com.auxilioservico.backend.dtos.ServicoDTO
import com.auxilioservico.backend.dtos.ServicoResponseDTO
import com.auxilioservico.backend.service.ServicoService
import jakarta.transaction.Transactional
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid


@RestController
@RequestMapping
class ServicoController (private val service: ServicoService) {

    @GetMapping
    fun listar():List<ServicoResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ServicoResponseDTO{
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid dto: ServicoDTO,
                  uriBuilder: UriComponentsBuilder
    ): ResponseEntity<ServicoResponseDTO> {
        val servicoResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/servicos/${servicoResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(servicoResponse)
    }

    @PutMapping
    @Transactional
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @Valid dto: ServicoDTO
    ): ServicoResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long) {
        service.deletar(id)
    }

}