package dtos

import java.time.Instant

data class PesquisaDTO(

    val servico_id: Int,
    val data_da_pesquisa: Instant = Instant.now()
)
