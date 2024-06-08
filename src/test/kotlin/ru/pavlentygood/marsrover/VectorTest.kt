package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.Side.NORTH

class VectorTest {

    private val vector = Vector(x = 0, y = 1, limit = 9, side = NORTH)

    @Test
    fun `one step`() {
        vector
            .step(Point(x = 0, y = 6)) shouldBe Point(0, 7)
    }

    @Test
    fun `step limit`() {
        vector.step(Point(x = 0, y = 9)) shouldBe Point(0, 9)
    }
}
