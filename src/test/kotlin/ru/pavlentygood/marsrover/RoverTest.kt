package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RoverTest {

    @Test
    fun `one step`() {
        rover.step().current shouldBe xCoordinate.step()
    }

    @Test
    fun `all turns`() {
        rover.turn().apply {
            current shouldBe yCoordinate.reversed()
            other shouldBe xCoordinate
        }
    }
}

val xWay = Way(offset = FORWARD, limit = 8)
val yWay = Way(offset = FORWARD, limit = 3)
val backward = Way(offset = BACKWARD, limit = 0)
val xCoordinate = Coordinate(
    value = 1,
    current = xWay,
    other = backward
)
val yCoordinate = Coordinate(
    value = 4,
    current = yWay,
    other = backward
)
val rover = Rover(current = xCoordinate, other = yCoordinate)
