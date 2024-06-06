package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.Direction.*

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
    fun `test right`() {
        Rover(x = 0, limit = 0)
            .right().apply { direction shouldBe SOUTH }
            .right().apply { direction shouldBe WEST }
            .right().apply { direction shouldBe NORTH }
            .right().apply { direction shouldBe EAST }
    }

    @Test
    fun `test left`() {
        Rover(x = 0, limit = 0)
            .left().apply { direction shouldBe NORTH }
            .left().apply { direction shouldBe WEST }
            .left().apply { direction shouldBe SOUTH }
            .left().apply { direction shouldBe EAST }
    }

    @Test
    fun `right, step - x not changed`() {
        Rover(x = 1, limit = 2)
            .right().step().apply {
                x shouldBe 1
                direction shouldBe SOUTH
            }
    }
}
