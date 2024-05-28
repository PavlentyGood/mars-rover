package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.Action.*
import ru.pavlentygood.marsrover.Direction.*

class RoverTest {

    @Test
    fun `move to every directions`() {
        fun move(direction: Direction, x: Int, y: Int) {
            val origin = Rover(width = 2, height = 2, x = 1, y = 1, direction = direction)
            val result: Rover = origin.doAction(MOVE)
            result.x shouldBe x
            result.y shouldBe y
        }
        move(NORTH, 1, 2)
        move(EAST, 2, 1)
        move(SOUTH, 1, 0)
        move(WEST, 0, 1)
    }

    @Test
    fun `rotate to right and left`() {
        fun turn(action: Action, begin: Direction, end: Direction) {
            val origin = Rover(width = 0, height = 0, x = 0, y = 0, direction = begin)
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

    @Test
    fun `field limit`() {
        fun move(direction: Direction) {
            val origin = Rover(width = 0, height = 0, x = 0, y = 0, direction = direction)
            val rover = origin.doAction(MOVE)
            rover.x shouldBe 0
            rover.y shouldBe 0
        }
        move(NORTH)
        move(EAST)
        move(SOUTH)
        move(WEST)
    }
}
