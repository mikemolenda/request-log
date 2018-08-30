package com.mikemolenda.requestlog

import com.google.appengine.api.datastore.DatastoreServiceFactory
import com.google.appengine.api.datastore.Entity
import com.google.appengine.api.datastore.Query
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class RequestLogController {

    val datastore = DatastoreServiceFactory.getDatastoreService()

    @RequestMapping(value = ["/test"], method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getDefault(@RequestParam(value = "name", required = false) name: String?): Response {
        try {
            val requestEntity = Entity("Request")
            requestEntity.setProperty("endpoint", "/test")
            requestEntity.setProperty("method", "GET")
            datastore.put(requestEntity)
        } catch (npe: NullPointerException) {
            npe.printStackTrace()
        }

        return Response("Hello ${name ?: "World"}")
    }

    @RequestMapping(value = ["/test"], method = [RequestMethod.POST], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun postDefault(@RequestBody(required = false) request: Request?): Response {
        return Response("Hello ${request?.name ?: "World"}")
    }

//    @RequestMapping("/requests")
//    fun getRequests(): List<RequestData> {
//        val query = Query("Request")
//        val preparedQuery = datastore.prepare(query)
//        val requests = preparedQuery.asIterable().map {
//            RequestData(
//                    endpoint = it.getProperty("endpoint").toString(),
//                    method = it.getProperty("method").toString()
//            )
//        }.toList()
//
//        return requests
//    }

}

data class Request(val name: String?)
data class Response(val message: String)
data class RequestData(val endpoint: String, val method: String)