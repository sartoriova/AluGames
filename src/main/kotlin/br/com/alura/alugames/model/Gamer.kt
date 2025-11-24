package br.com.alura.alugames.model

import br.com.alura.alugames.utils.getAge
import java.util.Scanner
import kotlin.random.Random

data class Gamer(var name: String, var email: String) {
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

    constructor(name: String, email: String, dateOfBirth:String, userName:String) : this(name, email) {
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

    fun generateId() {
        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)

        id = "$userName#$tag"
    }

    fun validateEmail(): Boolean {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")

        return regex.matches(email)
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
        return "Gamer(name='$name', email='$email', dateOfBirth=$dateOfBirth, age=$age, userName=$userName, id=$id, favoriteGames=$favoriteGames)"
    }
}
