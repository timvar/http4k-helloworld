package com.example

import org.http4k.client.JavaHttpClient
import org.http4k.core.*
import org.http4k.filter.DebuggingFilters.PrintResponse

fun main() {
    val client: org.http4k.core.HttpHandler = JavaHttpClient()
    val printingClient: org.http4k.core.HttpHandler = PrintResponse().then(client)
    val response: Response = printingClient(Request(Method.GET, "http://localhost:9000/pong"))
    println(response.bodyString())
}