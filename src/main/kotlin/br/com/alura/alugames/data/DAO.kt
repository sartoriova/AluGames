package br.com.alura.alugames.data

import javax.persistence.EntityManager

abstract class DAO <TModel, TEntity>(protected val manager: EntityManager, protected val entityType: Class<TEntity>) {
    abstract fun toEntity(element: TModel): TEntity
    abstract fun toModel(entity: TEntity): TModel

    open fun getList(): List<TModel> {
        val query = manager.createQuery("FROM ${entityType.simpleName}", entityType)

        return query.resultList.map {
            toModel(it)
        }
    }

    open fun add(element: TModel) {
        val entity = toEntity(element)

        manager.transaction.begin()

        manager.persist(entity)

        manager.transaction.commit()
    }

    open fun getById(id: Int): TModel {
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id = :id", entityType)

        query.setParameter("id", id)

        return toModel(query.singleResult)
    }

    open fun deleteById(id: Int) {
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id = :id", entityType)

        query.setParameter("id", id)

        val entity = query.singleResult

        manager.transaction.begin()

        manager.remove(entity)

        manager.transaction.commit()
    }
}