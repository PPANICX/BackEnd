package com.auxilioservico.backend.controller

import com.auxilioservico.backend.dtos.ServicoDTO
import com.auxilioservico.backend.dtos.ServicoResponseDTO
import com.auxilioservico.backend.service.ServicoService
import jakarta.transaction.Transactional
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid


@RestController
@RequestMapping("/servicos")
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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }

}