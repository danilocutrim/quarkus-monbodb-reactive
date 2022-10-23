package com.quarkus.mongo.sample.model.entity

import io.quarkus.mongodb.panache.common.MongoEntity
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoEntity

@MongoEntity(collection = "user")
data class UserEntity(
    var documentNumber: String? = null,
    var name: String? = null,
    var lastName: String? = null,
    var email: String? = null
) : ReactivePanacheMongoEntity()
