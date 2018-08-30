package com.mikemolenda.requestlog

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class RequestLogApplication {

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(RequestLogApplication::class.java, *args)
        }
    }

}