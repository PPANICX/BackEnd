package com.auxilioservico.backend.controller

import com.auxilioservico.backend.dtos.PesquisaDTO
import com.auxilioservico.backend.dtos.PesquisaResponseDTO
import com.auxilioservico.backend.model.Pesquisa
import com.auxilioservico.backend.service.PesquisaService
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
import org.springframework.web.util.UriBuilder
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/pesquisa")
class PesquisaController (private val service: PesquisaService){

    @GetMapping
    fun listar():List<PesquisaResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): PesquisaResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid dto: PesquisaDTO,
                  uriBuilder: UriComponentsBuilder
    ): ResponseEntity<PesquisaResponseDTO> {
        val pesquisaResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/pesquisas/${pesquisaResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(pesquisaResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @Valid dto: PesquisaDTO
    ): PesquisaResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }


}