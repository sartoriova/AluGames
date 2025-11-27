package br.com.alura.alugames.data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "GAMERS")
class GamerEntity (
    val nome: String = "",
    val email: String = "",
    val dataNascimento: String? = null,
    val usuario: String? = null,
    @ManyToOne
    val plano: PlanEntity = IndividualPlanEntity(),
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0
)