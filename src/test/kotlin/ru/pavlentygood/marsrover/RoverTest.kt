package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RoverTest {

    @Test
    fun `test step`() {
        Rover(x = 1, limit = 2).step().x shouldBe 2
    }

    @Test
    fun `step limit`() {
        Rover(x = 5, limit = 5).step().x shouldBe 5
    }

    @Test
    fun `many steps`() {
        Rover(x = 2, limit = 0).execute(actions = listOf(MOVE, MOVE)).x shouldBe 4
    }
}
