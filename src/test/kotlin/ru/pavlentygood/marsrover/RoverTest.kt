package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.Action.*
import ru.pavlentygood.marsrover.Direction.*

class RoverTest {

    @Test
    fun `to move`() {
        val origin = Rover(x = 0, y = 0, direction = NORTH)
        val result: Rover = origin
            .doAction(MOVE)
            .doAction(MOVE)
        result.x shouldBe 0
        result.y shouldBe 2
    }

    @Test
    fun `rotate to right, left`() {
        fun turn(action: Action, begin: Direction, end: Direction) {
            val origin = Rover(x = 0, y = 0, direction = begin)
            val result: Rover = origin.doAction(action)
            result.x shouldBe 0
            result.y shouldBe 0
            result.direction shouldBe end
        }
        turn(RIGHT, NORTH, EAST)
        turn(RIGHT, EAST, SOUTH)
        turn(RIGHT, SOUTH, WEST)
        turn(RIGHT, WEST, NORTH)
        turn(LEFT, NORTH, WEST)
        turn(LEFT, WEST, SOUTH)
        turn(LEFT, SOUTH, EAST)
        turn(LEFT, EAST, NORTH)
    }
}
