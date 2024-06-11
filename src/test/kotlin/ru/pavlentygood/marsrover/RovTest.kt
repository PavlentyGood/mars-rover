package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.Side.*

class RovTest {

    @Test
    fun right() {
        rover().right() shouldBe rover(side = SOUTH)
    }

    @Test
    fun `step by x`() {
        rover().step() shouldBe rover(x = 3)
    }

    @Test
    fun `step by y`() {
        rover(side = NORTH).step() shouldBe rover(y = 6, side = NORTH)
    }

    private fun rover(x: Int = 2, y: Int = 5, side: Side = EAST) =
        Rov(
            x = Coord(value = x, limit = 8),
            y = Coord(value = y, limit = 9),
            side = side
        )
}
