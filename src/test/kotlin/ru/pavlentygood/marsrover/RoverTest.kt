package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.Action.*
import ru.pavlentygood.marsrover.Direction.*

class RoverTest {

    @Test
    fun `move to every directions`() {
        val x = vector(1)
        val y = vector(1)

        fun moved(direction: Direction) =
            Rover(x = x, y = y, direction = direction)
                .doAction(MOVE)

        moved(NORTH).y shouldNotBe y
        moved(EAST).x shouldNotBe x
        moved(SOUTH).y shouldNotBe y
        moved(WEST).x shouldNotBe x
    }

    @Test
    fun `rotate to right and left`() {
        fun turn(action: Action, begin: Direction, end: Direction) {
            val origin = Rover(x = vector(0), y = vector(0), direction = begin)
            val result: Rover = origin.doAction(action)
            result.x shouldBe origin.x
            result.y shouldBe origin.y
            result.direction shouldBe end
        }
        turn(action = RIGHT, begin = NORTH, end = EAST)
        turn(action = LEFT, begin = WEST, end = SOUTH)
    }

    private fun vector(value: Int) = Vector(value = value, limit = 2)
}
