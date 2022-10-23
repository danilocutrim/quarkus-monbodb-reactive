package com.quarkus.mongo.sample.model.request.inbound

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import io.quarkus.mongodb.panache.common.jackson.ObjectIdSerializer
import io.quarkus.runtime.annotations.RegisterForReflection
import org.bson.types.ObjectId

@RegisterForReflection
data class UserRequest(
    @field:JsonProperty("userId")
    @field:JsonSerialize(using = ObjectIdSerializer::class)
    var id: ObjectId? = null,
    @field:JsonProperty("documentNumber")
    val documentNumber: String? = null,
    @field:JsonProperty("name")
    val name: String? = null,
    @field:JsonProperty("lastName")
    val lastName: String? = null,
    @field:JsonProperty("email")
    val email: String? = null
)
