package br.com.alura.alugames.utils

import br.com.alura.alugames.data.RentalEntity
import br.com.alura.alugames.model.Rental

fun Rental.toEntity(): RentalEntity {
    return RentalEntity(this.gamer.toEntity(), this.game.toEntity(), this.period)
}

fun RentalEntity.toModel():Rental {
    return Rental(this.gamer.toModel(), this.game.toModel(), this.period)
}