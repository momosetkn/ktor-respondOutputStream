package com.example;

import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.routing.Route
import io.ktor.server.resources.get
import io.ktor.server.application.call
import io.ktor.server.response.respondBytes
import io.ktor.server.response.respondOutputStream
import java.io.ByteArrayInputStream

fun Route.fileResourceHandler() {
    get<FileResources.RespondOutputStream> { params ->
        val s = "hello world"
        val inputStream = ByteArrayInputStream(s.toByteArray(Charsets.UTF_8))
        call.respondOutputStream(
            status = HttpStatusCode.OK
        ) {
            inputStream.use { input ->
                input.copyTo(this)
            }
        }
    }

    // workaround
    get<FileResources.WorkaroundWithRespondBytes> { params ->
        val s = "hello world"
        val inputStream = ByteArrayInputStream(s.toByteArray(Charsets.UTF_8))
        call.respondOutputStream(
            status = HttpStatusCode.OK
        ) {
            inputStream.use { input ->
                input.copyTo(this)
            }
        }
        // this code to trick IntelliJ
        if (false) {
            call.respondBytes(
                contentType = ContentType.Application.OctetStream,
                status = HttpStatusCode.OK
            ) {
                ByteArray(0)
            }
        }
    }
}
