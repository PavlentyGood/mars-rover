package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class WayTest {

    @Test
    fun `one step`() {
        Way(offset = FORWARD, limit = 4).step(2) shouldBe 3
    }

    @Test
    fun `step limit`() {
        Way(offset = FORWARD, limit = 5).step(5) shouldBe 5
    }
}
