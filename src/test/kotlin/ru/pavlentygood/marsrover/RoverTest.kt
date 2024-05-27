package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RoverTest {

    @Test
    fun `to move`() {
        val rover = Rover(x = 0, y = 0, direction = Direction.NORTH)
        rover.doAction(Action.MOVE)
        rover.x shouldBe 0
        rover.y shouldBe 1
    }

    @Test
    fun `to move two times`() {
        val rover = Rover(x = 0, y = 0, direction = Direction.NORTH)
        rover.doAction(Action.MOVE)
        rover.doAction(Action.MOVE)
        rover.x shouldBe 0
        rover.y shouldBe 2
    }
}
