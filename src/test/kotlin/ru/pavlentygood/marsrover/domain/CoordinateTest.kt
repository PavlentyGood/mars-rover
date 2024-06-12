package ru.pavlentygood.marsrover.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CoordinateTest {

    @Test
    fun `create coordinate - invalid parameters`() {
        shouldThrow<IllegalArgumentException> {
            Coordinate.create(value = 2, limit = 1)
        }
    }

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
