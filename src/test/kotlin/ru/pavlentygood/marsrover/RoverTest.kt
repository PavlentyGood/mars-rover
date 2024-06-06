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
    fun `test turn`() {
        rover()
            .turn().apply { way.direction shouldBe WEST }
            .turn().apply { way.direction shouldBe EAST }
    }

    @Test
    fun `turn, step`() {
        rover(x = 1).turn().step()
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
            forward = it,
            backward = Way(direction = WEST, limit = 0)
        )
    }
