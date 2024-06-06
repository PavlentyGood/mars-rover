package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.Direction.*

class DirectionTest {

    @Test
    fun `next direction`() {
        NORTH.next() shouldBe EAST
        EAST.next() shouldBe SOUTH
        SOUTH.next() shouldBe WEST
        WEST.next() shouldBe NORTH
    }
}
