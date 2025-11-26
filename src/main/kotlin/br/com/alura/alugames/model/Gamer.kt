package br.com.alura.alugames.model

import br.com.alura.alugames.utils.getAge
import java.time.LocalDate
import java.util.Scanner
import kotlin.random.Random

data class Gamer(var name: String, var email: String) : Recommendation {
    var dateOfBirth:String? = null
        set(value) {
            field = value
            this.age = value?.getAge()
        }
    var age: Int? = null
    var userName:String? = null
        set(value) {
            field = value
            if (id.isNullOrBlank()) {
                generateId()
            }
        }
    var id:String? = null
        private set //somente a classe Gamer pode alterar o valor
    val favoriteGames = mutableListOf<Game?>()
    val rentedGames = mutableListOf<Rental>()
    var plan: Plan = IndividualPlan("bronze")
    val scores = mutableListOf<Int>()
    val recommendedGames = mutableListOf<Game>()

    constructor(name: String, email: String, dateOfBirth:String?, userName:String?, id:Int = 0) : this(name, email) {
        this.dateOfBirth = dateOfBirth
        this.userName = userName
        generateId()
    }

    init {
        if (!validateEmail()) throw IllegalArgumentException("Invalid e-mail")
        this.email = email

        if (name.isBlank()) throw IllegalArgumentException("Invalid name!")
        this.name = name
    }

    override val average: Double
        get() = scores.average()

    override fun recommend(score: Int) {
        if (score < 1 || score > 10) throw IllegalArgumentException("Invalid score!")
        scores.add(score)
    }

    fun recommendGame(game: Game, score: Int) {
        game.recommend(score)
        recommendedGames.add(game)
    }

    fun generateId() {
        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)

        id = "$userName#$tag"
    }

    fun validateEmail(): Boolean {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")

        return regex.matches(email)
    }

    fun rentGame(game: Game, initialDate: LocalDate, finalDate: LocalDate): Rental {
        val rental = Rental(this, game, MyPeriod(initialDate, finalDate))
        rentedGames.add(rental)

        return rental
    }

    fun getMonthlyGames(month:Int): List<Game> {
        return rentedGames
            .filter { rental ->  rental.period.initialDate.monthValue == month}
            .map { rental ->  rental.game}
    }

    companion object {
        fun createGamer(input: Scanner): Gamer {
            println("Welcome to AluGames!")

            println("\nTo begin your registration, enter your name:")
            val name = input.nextLine()

            println("\nEnter your e-mail:")
            val email = input.nextLine()

            println("\nDo you want to finish your register with user name and date of birth? (Y/N)")
            val option = input.nextLine()

            if (option.equals("Y", true)) {
               return completeRegistration(input, Gamer(name, email))
            }

            return Gamer(name, email)
        }

        fun completeRegistration(input: Scanner, gamer: Gamer): Gamer {
            println("\nEnter your date of birth (DD/MM/AAAA):")
            val dateOfBirth = input.nextLine()

            println("\nEnter your user name:")
            val userName = input.nextLine()

            gamer.dateOfBirth = dateOfBirth
            gamer.userName = userName

            return gamer
        }
    }

    override fun toString(): String {
        return String.format(
            """
                -----
                Id: %s
                Name: %s
                Email: %s
                Date of birth: %s
                User name: %s
                Reputation: %.2f
            """, id, name, email, dateOfBirth, userName, average)
    }
}
