package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.Direction.*

class DirectionTest {

    @Test
    fun `on right`() {
        NORTH.onRight() shouldBe EAST
        EAST.onRight() shouldBe SOUTH
        SOUTH.onRight() shouldBe WEST
        WEST.onRight() shouldBe NORTH
    }

    @Test
    fun `on left`() {
        NORTH.onLeft() shouldBe WEST
        WEST.onLeft() shouldBe SOUTH
        SOUTH.onLeft() shouldBe EAST
        EAST.onLeft() shouldBe NORTH
    }
}
