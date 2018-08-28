package com.mikemolenda.requestlog

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class RequestLogController {
    @RequestMapping(value=["/"],method=[RequestMethod.GET],produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getDefault(): Response {
        return Response("OK")
    }
}

data class Response(val message: String)