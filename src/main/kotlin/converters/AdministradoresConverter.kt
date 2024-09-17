package converters

import com.auxilioservico.backend.model.Administradores
import dtos.AdministradoresDTO
import org.springframework.stereotype.Component

@Component
    class AdministradoresConverter {
        fun toAdministrador(dto: AdministradoresDTO): Administradores{

            return Administradores(
                nome = dto.nome,
                email = dto.email,
                senha = dto.senha,
                tipo = dto.tipo,
                criacao = dto.criacao.toString()
            )
        }
}