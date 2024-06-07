package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RoverTest {

    @Test
    fun `get output data`() {
        rover.apply {
            x.value shouldBe 1
            y.value shouldBe 4
            side shouldBe Side.EAST
        }
    }

    @Test
    fun `step by x`() {
        rover.step().apply {
            current shouldBe xCoordinate.step()
            x shouldBe xCoordinate.step()
        }
    }

    @Test
    fun `step by y`() {
        rover.turn().step().apply {
            current shouldBe yCoordinate.reversed().step()
            y shouldBe yCoordinate.reversed().step()
        }
    }

    @Test
    fun `all turns`() {
        rover.turn().apply {
            current shouldBe yCoordinate.reversed()
            y shouldBe yCoordinate.reversed()
        }
        rover.turn().turn().apply {
            current shouldBe xCoordinate.reversed()
            x shouldBe xCoordinate.reversed()
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
val rover = Rover(current = xCoordinate, x = xCoordinate, y = yCoordinate)
