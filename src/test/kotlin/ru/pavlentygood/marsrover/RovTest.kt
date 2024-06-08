package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.Side.EAST
import ru.pavlentygood.marsrover.Side.SOUTH

class RovTest {

    private val east = Vector(x = 1, y = 0, limit = 9, side = EAST)
    private val south = Vector(x = 0, y = -1, limit = 0, side = SOUTH)
    private val rover = Rov(
        point = Point(x = 4 , y = 2),
        currentVector = east,
        vectors = listOf(east, south)
    )

    @Test
    fun `turn to right`() {
        rover.right().side shouldBe SOUTH
    }

    @Test
    fun `step to east`() {
        rover.step().x shouldBe 5
    }
}
