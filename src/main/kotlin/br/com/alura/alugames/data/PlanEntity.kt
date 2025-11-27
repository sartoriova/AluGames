package br.com.alura.alugames.data

import javax.persistence.DiscriminatorColumn
import javax.persistence.DiscriminatorType
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.InheritanceType
import javax.persistence.Table

@Entity
@Table(name = "PLANOS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoPlano", discriminatorType = DiscriminatorType.STRING)
sealed class PlanEntity(
    val tipo: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0)

@Entity
@DiscriminatorValue("Individual")
class IndividualPlanEntity(tipo: String = "", id: Int = 0): PlanEntity(tipo, id)

@Entity
@DiscriminatorValue("Assinatura")
class SubscriptionPlanEntity(
    tipo: String = "",
    val mensalidade: Double = 0.0,
    val jogosIncluidos: Int = 0,
    val percentualDescontoReputacao: Double = 0.0,
    id: Int = 0): PlanEntity(tipo, id)