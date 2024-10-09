package converters

import com.auxilioservico.backend.dtos.PesquisaDTO
import com.auxilioservico.backend.model.Pesquisa
import org.springframework.stereotype.Component

@Component
class PesquisaConverter {
    fun toPesquisa (dto: PesquisaDTO): Pesquisa {
        return Pesquisa(
            data = dto.data,
            servico = dto.servico
        )
    }
}