package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RoverTest {

    @Test
    fun `test step`() {
        rover(x = 1).step().x shouldBe 2
    }

    @Test
    fun `test turn`() {
        rover()
            .turn().apply { way.offset shouldBe BACKWARD }
            .turn().apply { way.offset shouldBe FORWARD }
    }

    @Test
    fun `turn, step`() {
        rover(x = 1).turn().step()
            .apply {
                x shouldBe 0
                way.offset shouldBe BACKWARD
            }
    }
}

fun rover(x: Int = 0) =
    Way(offset = FORWARD, limit = 8)
        .let {
            Rover(
                x = x,
                way = it,
                forward = it,
                backward = Way(offset = BACKWARD, limit = 0)
            )
        }
