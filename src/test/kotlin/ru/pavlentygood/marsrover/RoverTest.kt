package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.Direction.*
import java.util.LinkedList

class RoverTest {

    @Test
    fun `test step`() {
        rover(x = 1).step().x shouldBe 2
    }

    @Test
    fun `test right`() {
        rover()
            .right().apply { direction shouldBe SOUTH }
            .right().apply { direction shouldBe WEST }
            .right().apply { direction shouldBe NORTH }
            .right().apply { direction shouldBe EAST }
    }

    @Test
    fun `test left`() {
        rover().left().direction shouldBe NORTH
    }

    @Test
    fun `right, step - x not changed`() {
        rover(x = 1)
            .right().step().apply {
                x shouldBe 1
                direction shouldBe SOUTH
            }
    }
}

fun rover(x: Int = 0) =
    Rover(
        x = x,
        ways = LinkedList(listOf(
            Way(direction = EAST, limit = 8),
            Way(direction = SOUTH, limit = 0),
            Way(direction = WEST, limit = 0),
            Way(direction = NORTH, limit = 5)
        ))
    )
