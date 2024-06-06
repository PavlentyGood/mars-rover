package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.Direction.*

class RoverTest {

    @Test
    fun `test step`() {
        rover(x = 1).step().x shouldBe 2
    }

    @Test
    fun `test right`() {
        rover()
            .right().apply { way.direction shouldBe WEST }
            .right().apply { way.direction shouldBe EAST }
    }

    @Test
    fun `test left`() {
        rover().left().way.direction shouldBe WEST
    }

    @Test
    fun `right, step`() {
        rover(x = 1).right().step()
            .apply {
                x shouldBe 0
                way.direction shouldBe WEST
            }
    }
}

fun rover(x: Int = 0) =
    Way(direction = EAST, limit = 8).let {
        Rover(
            x = x,
            way = it,
            ways = mapOf(
                EAST to it,
                WEST to Way(direction = WEST, limit = 0)
            )
        )
    }
