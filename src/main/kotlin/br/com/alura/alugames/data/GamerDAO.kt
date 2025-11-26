package br.com.alura.alugames.data

import br.com.alura.alugames.model.Gamer
import javax.persistence.EntityManager

class GamerDAO(manager: EntityManager): DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {
    override fun toEntity(element: Gamer): GamerEntity {
        return GamerEntity(element.name, element.email, element.dateOfBirth, element.userName)
    }

    override fun toModel(entity: GamerEntity): Gamer {
       return Gamer(entity.nome, entity.email, entity.dataNascimento, entity.usuario, entity.id)
    }
}