package com.quarkus.mongo.sample.repository

import com.quarkus.mongo.sample.model.entity.UserEntity
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoRepository
import io.smallrye.mutiny.coroutines.awaitSuspending
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class UserRepository : ReactivePanacheMongoRepository<UserEntity> {
    suspend fun findByDocumentNumber(documentNumber: String?) =
        find("documentNumber", documentNumber).list().awaitSuspending()

    suspend fun save(userEntity: UserEntity) = persist(userEntity).awaitSuspending()
}
