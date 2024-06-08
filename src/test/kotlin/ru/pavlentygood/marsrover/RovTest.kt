package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.Side.EAST
import ru.pavlentygood.marsrover.Side.SOUTH

class RovTest {

    @Test
    fun `turn to right`() {
        val east = Vector(x = 1, y = 0, limit = 9, side = EAST)
        val south = Vector(x = 0, y = -1, limit = 8, side = SOUTH)
        Rov(
            x = 4,
            y = 2,
            currentVector = east,
            vectors = listOf(east, south)
        )
            .right().side shouldBe SOUTH
    }

    @Test
    fun `one step`() {
        val east = Vector(x = 1, y = 0, limit = 9, side = EAST)
        val south = Vector(x = 0, y = -1, limit = 8, side = SOUTH)
        Rov(
            x = 4,
            y = 2,
            currentVector = east,
            vectors = listOf(east, south)
        ).step().x shouldBe 5
    }
}
