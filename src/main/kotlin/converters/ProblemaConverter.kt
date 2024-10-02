package converters

import com.auxilioservico.backend.dtos.ProblemaDTO
import org.springframework.stereotype.Component
import com.auxilioservico.backend.model.Problema

@Component
class ProblemaConverter {

    fun toProblema (dto: ProblemaDTO): Problema{
        return Problema(
            servico_id = dto.servico_id,
            descricao = dto.descricao,
            status = dto.status,
            criacao = dto.criacao,
            resolucao = dto.resolucao
        )

    }
}