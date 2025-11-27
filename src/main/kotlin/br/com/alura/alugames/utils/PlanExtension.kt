package br.com.alura.alugames.utils

import br.com.alura.alugames.data.IndividualPlanEntity
import br.com.alura.alugames.data.PlanEntity
import br.com.alura.alugames.data.SubscriptionPlanEntity
import br.com.alura.alugames.model.IndividualPlan
import br.com.alura.alugames.model.Plan
import br.com.alura.alugames.model.SubscriptionPlan

fun Plan.toEntity(): PlanEntity {
    if (this is SubscriptionPlan) {
        return SubscriptionPlanEntity(this.type, this.monthlyPayment, this.includedGames, this.discountPercentage, this.id)
    }

    return IndividualPlanEntity(this.type, this.id)
}

fun PlanEntity.toModel(): Plan {
    if (this is SubscriptionPlanEntity) {
        return SubscriptionPlan(this.tipo, this.mensalidade, this.jogosIncluidos, this.percentualDescontoReputacao, this.id)
    }

    return IndividualPlan(this.tipo, this.id)
}