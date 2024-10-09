package converters

import com.auxilioservico.backend.dtos.TopicoDTO
import com.auxilioservico.backend.model.Topico
import org.springframework.stereotype.Component


@Component
class TopicoConverter{

    fun toTopico(dto: TopicoDTO): Topico {

        return Topico(
            nome = dto.nome,
            descricao = dto.descricao,
            criacao = dto.criacao,
            ativo = dto.ativo
        )
    }
}