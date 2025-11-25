package br.com.alura.alugames.model

data class Rental (val gamer: Gamer, val game: Game, val period: MyPeriod) {
    val rentalPrice = gamer.plan.getPrice(this)

    override fun toString(): String {
        return "Rental(gamer=${gamer.name}, game=${game.title}, initialDate=${period.initialDate}, finalDate=${period.finalDate}, rentalPrice=$rentalPrice)"
    }
}