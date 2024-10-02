package converters

import com.auxilioservico.backend.model.Pesquisa
import dtos.PesquisaDTO
import org.springframework.stereotype.Component


@Component
class PesquisaConverter {
    fun toPesquisa(dto: PesquisaDTO): Pesquisa {

        return Pesquisa(
            data = dto.data_da_pesquisa.toString(),
            servico_id = dto.servico_id.toString()
        )
    }
}
