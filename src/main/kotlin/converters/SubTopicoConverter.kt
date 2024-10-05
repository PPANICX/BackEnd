package converters

import com.auxilioservico.backend.dtos.SubTopicoDTO
import com.auxilioservico.backend.model.SubTopico
import org.springframework.stereotype.Component

@Component
class SubTopicoConverter {

    fun toSubTopico(dto: SubTopicoDTO): SubTopico{
        return SubTopico(
            nome = dto.nome,
            servicos = dto.servicos
        )
    }
}