package com.quarkus.mongo.sample.controller

import com.quarkus.mongo.sample.model.entity.UserEntity
import com.quarkus.mongo.sample.model.request.inbound.UserRequest
import com.quarkus.mongo.sample.model.response.inbound.SaveUserResponse
import com.quarkus.mongo.sample.service.UserService
import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

@Path("/user")
@ApplicationScoped
class UserController(private val userService: UserService) {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    suspend fun saveUser(user: UserRequest): SaveUserResponse {
        return userService.saveUser(user)
    }

    @GET()
    @Path("user")
    suspend fun getUserByDocumentNumber(@QueryParam(value = "documentNumber") documentNumber: String): List<UserEntity> {
        return userService.userByDocumentNumber(documentNumber) ?: throw Exception("")
    }

    @GET
    suspend fun getUserById(@QueryParam(value = "userId") userId: String): UserEntity {
        return userService.userById(userId) ?: throw Exception("")
    }
}
