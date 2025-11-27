package br.com.alura.alugames.data

import br.com.alura.alugames.model.Gamer
import br.com.alura.alugames.utils.toEntity
import br.com.alura.alugames.utils.toModel
import javax.persistence.EntityManager

class GamerDAO(manager: EntityManager): DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {
    override fun toEntity(element: Gamer): GamerEntity {
        return element.toEntity()
    }

    override fun toModel(entity: GamerEntity): Gamer {
       return entity.toModel().apply { plan = entity.plano.toModel() }
    }
}