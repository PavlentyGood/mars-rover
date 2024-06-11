package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CoordinateTest {

    @Test
    fun add() {
        coordinate(5).add(1) shouldBe coordinate(6)
    }

    @Test
    fun `min limit`() {
        coordinate(0).add(-1) shouldBe coordinate(0)
    }

    @Test
    fun `max limit`() {
        coordinate(7).add(1) shouldBe coordinate(7)
    }

    private fun coordinate(value: Int) =
        Coordinate(
            value = value,
            limit = 7
        )
}
