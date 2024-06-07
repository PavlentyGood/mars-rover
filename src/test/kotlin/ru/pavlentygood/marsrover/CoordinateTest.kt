package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CoordinateTest {

    private val forward = Way(offset = FORWARD, limit = 9)
    private val backward = Way(offset = BACKWARD, limit = 0)

    private val coordinate = Coordinate(
        value = 7,
        currentWay = forward,
        forward = forward,
        backward = backward
    )

    @Test
    fun `one step`() {
        coordinate.step().value shouldBe forward.step(7)
    }

    @Test
    fun `reversed coordinate`() {
        coordinate
            .reversed().apply { currentWay shouldBe backward }
            .reversed().apply { currentWay shouldBe forward }
    }
}
