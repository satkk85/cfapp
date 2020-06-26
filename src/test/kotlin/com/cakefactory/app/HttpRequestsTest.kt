package com.cakefactory.app

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HttpRequestsTest {

    @LocalServerPort
    var port: Int = 0

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun testHome() {
        val responseEntity = restTemplate.getForEntity(uri(),String::class.java)
        assertTrue(responseEntity.statusCode.is2xxSuccessful)
    }

    fun uri(context: String = ""): String {
        return "http://localhost:$port/$context"
    }
}

