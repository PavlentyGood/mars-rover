package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.Direction.*

class DirectionTest {

    @Test
    fun `next direction`() {
        EAST.next() shouldBe WEST
        WEST.next() shouldBe EAST
    }
}
