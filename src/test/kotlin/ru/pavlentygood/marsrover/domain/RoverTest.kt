package ru.pavlentygood.marsrover.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.domain.Side.*

class RoverTest {

    @Test
    fun `create rover`() {
        Rover.create(width = 8, height = 9, x = 2, y = 5, side = EAST) shouldBe
                Rover(
                    x = Coordinate.create(value = 2, limit = 8),
                    y = Coordinate.create(value = 5, limit = 9),
                    side = EAST
                )
    }

    @Test
    fun `step by x`() {
        rover().step() shouldBe rover(x = 3)
    }

    @Test
    fun `step by y`() {
        rover(side = NORTH).step() shouldBe rover(y = 6, side = NORTH)
    }

    @Test
    fun right() {
        rover().right() shouldBe rover(side = SOUTH)
    }

    @Test
    fun left() {
        rover().left() shouldBe rover(side = NORTH)
    }
}

fun rover(x: Int = 2, y: Int = 5, side: Side = EAST) =
    Rover.create(width = 8, height = 9, x = x, y = y, side = side)
