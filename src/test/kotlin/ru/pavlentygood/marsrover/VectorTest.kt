package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.Side.NORTH

class VectorTest {

    @Test
    fun `one step`() {
        Vector(x = 0, y = 1, limit = 9, side = NORTH)
            .step(x = 0, y = 6) shouldBe listOf(0, 7)
    }

    @Test
    fun `step limit`() {
        Vector(x = 0, y = 1, limit = 9, side = NORTH)
            .step(x = 0, y = 9) shouldBe listOf(0, 9)
    }
}
