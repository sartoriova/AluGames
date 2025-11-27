package br.com.alura.alugames.model

class SubscriptionPlan(type: String, val monthlyPayment: Double, val includedGames: Int, val discountPercentage: Double, id: Int = 0): Plan(type, id) {
    override fun getPrice(rental: Rental): Double {
        val totalMonthlyGames = rental.gamer.getMonthlyGames(rental.period.initialDate.monthValue).size + 1

        if (totalMonthlyGames <= includedGames) {
            return 0.0
        }

        val originalPrice = super.getPrice(rental)

        if (rental.gamer.average >= 8) {
            return originalPrice - originalPrice * discountPercentage
        }

        return originalPrice
    }

    override fun toString(): String {
        return "SubscriptionPlan(id=$id, type=$type, monthlyPayment=$monthlyPayment, includedGames=$includedGames, discountPercentage=$discountPercentage)"
    }
}