package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.Direction.*

class RoverTest {

    @Test
    fun `test step`() {
        rover(x = 1, limit = 2).step().x shouldBe 2
    }

    @Test
    fun `step limit`() {
        rover(x = 5, limit = 5).step().x shouldBe 5
    }

    @Test
    fun `test right`() {
        rover(direction = EAST).right().direction shouldBe SOUTH
    }

    @Test
    fun `test left`() {
        rover(direction = EAST).left().direction shouldBe NORTH
    }

    @Test
    fun `right, step - x not changed`() {
        rover(x = 1, limit = 2)
            .right().step().apply {
                x shouldBe 1
                direction shouldBe SOUTH
            }
    }

    @Test
    fun `west limit`() {
        rover(x = 0, limit = 3, direction = WEST).step().x shouldBe 0
    }

    @Test
    fun `step to west from east limit`() {
        rover(x = 1, limit = 1, direction = WEST).step().x shouldBe 0
    }

    private fun rover(
        x: Int = 0,
        limit: Int = 0,
        direction: Direction = EAST
    ) =
        Rover(
            x = x,
            limit = limit,
            direction = direction
        )
}
