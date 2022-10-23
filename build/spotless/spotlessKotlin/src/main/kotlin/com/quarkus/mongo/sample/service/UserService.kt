package com.quarkus.mongo.sample.service

import com.quarkus.mongo.sample.model.entity.UserEntity
import com.quarkus.mongo.sample.model.request.inbound.UserRequest
import com.quarkus.mongo.sample.model.response.inbound.SaveUserResponse
import com.quarkus.mongo.sample.repository.UserRepository
import io.smallrye.mutiny.coroutines.awaitSuspending
import javax.enterprise.context.ApplicationScoped
import org.bson.types.ObjectId
import org.jboss.logging.Logger

@ApplicationScoped
class UserService(private val userRepository: UserRepository, private val logger: Logger) {

    suspend fun saveUser(user: UserRequest): SaveUserResponse {
        val entity = UserEntity(
            documentNumber = user.documentNumber,
            name = user.name,
            lastName = user.lastName,
            email = user.email
        )
        return SaveUserResponse(userRepository.save(entity).id.toString())
    }

    suspend fun userByDocumentNumber(documentNumber: String): List<UserEntity>? {
        return userRepository.findByDocumentNumber(documentNumber)
    }

    suspend fun userById(userId: String): UserEntity? {
        return userRepository.findById(ObjectId(userId)).awaitSuspending()
    }
}
