package com.mikemolenda.requestlog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RequestLogApplication

fun main(args: Array<String>) {
    runApplication<RequestLogApplication>(*args)
}
