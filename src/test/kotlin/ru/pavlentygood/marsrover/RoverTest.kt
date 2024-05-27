package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RoverTest {

    @Test
    fun `to move`() {
        val rover = Rover(x = 0, y = 0, direction = Direction.NORTH)
        rover.doAction(Action.MOVE)
        rover.doAction(Action.MOVE)
        rover.x shouldBe 0
        rover.y shouldBe 2
    }

    @Test
    fun `to right`() {
        fun toRight(times: Int, result: Direction) {
            val rover = Rover(x = 0, y = 0, direction = Direction.NORTH)
            repeat(times) {
                rover.doAction(Action.RIGHT)
            }
            rover.x shouldBe 0
            rover.y shouldBe 0
            rover.direction shouldBe result
        }

        toRight(1, Direction.EAST)
        toRight(2, Direction.SOUTH)
        toRight(3, Direction.WEST)
        toRight(4, Direction.NORTH)
    }
}
