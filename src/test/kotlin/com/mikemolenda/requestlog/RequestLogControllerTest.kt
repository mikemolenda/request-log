package com.mikemolenda.requestlog

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class RequestLogControllerTest {

    val subject = RequestLogController()

    @Test fun `should respond to GET request with no params`() {
        val expected = Response("Hello World")
        val actual = subject.getDefault(null)
        assertThat(actual).isEqualToComparingFieldByField(expected)
    }

    @Test fun `should respond to GET request with name param`() {
        val expected = Response("Hello Mike")
        val actual = subject.getDefault("Mike")
        assertThat(actual).isEqualToComparingFieldByField(expected)
    }

    @Test fun `should respond to POST request with no body`() {
        val expected = Response("Hello World")
        val actual = subject.postDefault(null)
        assertThat(actual).isEqualToComparingFieldByField(expected)
    }

    @Test fun `should respond to POST request with name in body`() {
        val expected = Response("Hello Mike")
        val actual = subject.postDefault(Request("Mike"))
        assertThat(actual).isEqualToComparingFieldByField(expected)
    }

}