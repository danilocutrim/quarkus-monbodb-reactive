package com.quarkus.mongo.sample.model.response.inbound

import com.fasterxml.jackson.annotation.JsonProperty

data class SaveUserResponse(
    @field:JsonProperty("userId")
    val userId: String
)
