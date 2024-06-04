package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class VectorTest {

    @Test
    fun next() {
        vector(1).next() shouldBe vector(2)
    }

    @Test
    fun prev() {
        vector(4).prev() shouldBe vector(3)
    }

    @Test
    fun `next limit`() {
        val origin = vector(5)
        origin.next() shouldBe origin
    }

    @Test
    fun `prev limit`() {
        val origin = vector(0)
        origin.prev() shouldBe origin
    }

    private fun vector(value: Int) = Vector(value = value, limit = 5)
}
