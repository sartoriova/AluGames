package br.com.alura.alugames.model

sealed class Plan (val type: String) {
    open fun getPrice(rental: Rental) : Double {
        return rental.period.inDays * rental.game.price
    }
}