package com.auxilioservico.backend.controller

import com.auxilioservico.backend.dtos.ProblemaDTO
import com.auxilioservico.backend.dtos.ProblemaResponseDTO
import com.auxilioservico.backend.service.ProblemaService
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
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid


@RestController
@RequestMapping("/problemas")
class ProblemaController (private val service: ProblemaService) {

    @GetMapping
    fun listar():List<ProblemaResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ProblemaResponseDTO{
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid dto: ProblemaDTO,
                  uriBuilder: UriComponentsBuilder
    ): ResponseEntity<ProblemaResponseDTO> {
        val problemaResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/problemas/${problemaResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(problemaResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @Valid dto: ProblemaDTO
    ): ProblemaResponseDTO {
        return service.atualizar(id, dto)
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }

}