package br.com.alura.alugames.data

import br.com.alura.alugames.model.Rental
import br.com.alura.alugames.utils.toEntity
import br.com.alura.alugames.utils.toModel
import javax.persistence.EntityManager

class RentalDAO(manager: EntityManager): DAO<Rental, RentalEntity>(manager, RentalEntity::class.java) {
    override fun toEntity(element: Rental): RentalEntity {
        return element.toEntity().apply {
            rentalPrice = element.rentalPrice
        }
    }

    override fun toModel(entity: RentalEntity): Rental {
        return entity.toModel().apply {
            id = entity.id
        }
    }
}