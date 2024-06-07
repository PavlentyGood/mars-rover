package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RoverTest {

    @Test
    fun `step by x`() {
        rover()
            .step().apply { x shouldBe xCoordinate.step() }
    }

    @Test
    fun `step by y`() {
        rover(coordinate = yCoordinate)
            .step().apply { y shouldBe yCoordinate.step() }
    }

    @Test
    fun `all turns`() {
        rover()
            .turn().apply { current shouldBe yCoordinate.reversed() }
            .turn().apply { current shouldBe xCoordinate.reversed() }
    }
}

fun rover(coordinate: Coordinate = xCoordinate): Rover {
    return Rover(
        current = coordinate,
        x = xCoordinate,
        y = yCoordinate
    )
}

val xWay = Way(offset = FORWARD, limit = 8)
val yWay = Way(offset = FORWARD, limit = 3)
val backward = Way(offset = BACKWARD, limit = 0)
val xCoordinate = Coordinate(
    value = 1,
    currentWay = xWay,
    forward = xWay,
    backward = backward
)
val yCoordinate = Coordinate(
    value = 4,
    currentWay = yWay,
    forward = yWay,
    backward = backward
)
