package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.Direction.*

class WayTest {

    @Test
    fun `test step`() {
        Way(direction = EAST, limit = 4).step(2) shouldBe 3
    }

    @Test
    fun `step limit`() {
        Way(direction = EAST, limit = 5).step(5) shouldBe 5
    }
}
