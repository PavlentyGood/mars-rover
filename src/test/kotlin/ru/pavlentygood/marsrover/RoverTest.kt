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
    fun `test right`() {
        Rover(x = 0, limit = 0)
            .right().apply { offsetIndex shouldBe 1 }
            .right().apply { offsetIndex shouldBe 2 }
            .right().apply { offsetIndex shouldBe 3 }
            .right().apply { offsetIndex shouldBe 0 }
    }

    @Test
    fun `test left`() {
        Rover(x = 0, limit = 0)
            .left().apply { offsetIndex shouldBe 3 }
            .left().apply { offsetIndex shouldBe 2 }
            .left().apply { offsetIndex shouldBe 1 }
            .left().apply { offsetIndex shouldBe 0 }
    }

    @Test
    fun `right, step - x not changed`() {
        Rover(x = 1, limit = 2)
            .right().step().apply {
                x shouldBe 1
                offsetIndex shouldBe 1
            }
    }
}
