package converters

import com.auxilioservico.backend.dtos.ServicoDTO
import com.auxilioservico.backend.model.Servico
import org.springframework.stereotype.Component

@Component
class ServicoConverter {

fun toServico(dto: ServicoDTO): Servico {

    return Servico(
        nome = dto.nome,
        brevedesc = dto.brevedesc,
        descricao = dto.descricao,
        imagem = dto.imagem,
        apiref = dto.apiref,
        apilocal = dto.apilocal
    )
}
}