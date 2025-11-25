package br.com.alura.alugames.model

interface Recommendation {
    val average: Double

    fun recommend(score: Int)
}