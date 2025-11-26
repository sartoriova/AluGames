package br.com.alura.alugames.data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "JOGOS")
class GameEntity(
    val titulo: String = "",
    val capa: String = "",
    val preco: Double = 0.0,
    val descricao: String = "",
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0)