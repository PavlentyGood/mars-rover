package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RoverTest {

    @Test
    fun `no actions`() {
        val rover = Rover(x = 0, y = 0, direction = Direction.NORTH)
        rover.move()
        rover.x shouldBe 0
        rover.y shouldBe 0
        rover.direction shouldBe Direction.NORTH
    }
}
