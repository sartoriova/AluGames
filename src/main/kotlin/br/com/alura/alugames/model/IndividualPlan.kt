package br.com.alura.alugames.model

class IndividualPlan (type: String, id: Int = 0) : Plan(type, id) {
    override fun getPrice(rental: Rental): Double {
        val originalPrice = super.getPrice(rental)

        if (rental.gamer.average >= 8) {
            return originalPrice - originalPrice * 0.1
        }

        return originalPrice
    }
}