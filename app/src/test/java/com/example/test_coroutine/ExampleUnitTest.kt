package com.example.test_coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun ex001() {
        GlobalScope.launch {
            delay(1000)
            println("world")
        }

        println("hello,")

        // 이곳에서 코루틴을 기다린다. 물론 global scope
        runBlocking {
            delay(2000) // delaying 2 seconds
        }
    }

    @Test
    fun ex002() = runBlocking {
        val job = GlobalScope.launch {
            delay(1000)
            println("world")
        }

        println("hello,")
        // scope 동작을 대기 함
        job.join()
    }


}
