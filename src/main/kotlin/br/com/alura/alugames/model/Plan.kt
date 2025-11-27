package br.com.alura.alugames.model

sealed class Plan (val type: String, val id: Int = 0) {
    open fun getPrice(rental: Rental) : Double {
        return rental.period.inDays * rental.game.price
    }

    override fun toString(): String {
        return "Plan(type='$type', id=$id)"
    }
}