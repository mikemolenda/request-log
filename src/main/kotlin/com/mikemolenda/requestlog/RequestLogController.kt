package com.mikemolenda.requestlog

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class RequestLogController {

    @RequestMapping(value = ["/test"], method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getDefault(@RequestParam(value = "name", required = false) name: String?): Response {
        return Response("Hello ${name ?: "World"}")
    }

    @RequestMapping(value = ["/test"], method = [RequestMethod.POST], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun postDefault(@RequestBody(required = false) request: Request?): Response {
        return Response("Hello ${request?.name ?: "World"}")
    }
}

data class Request(val name: String?)
data class Response(val message: String)