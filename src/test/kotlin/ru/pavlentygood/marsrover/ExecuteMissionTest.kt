package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.Action.*
import ru.pavlentygood.marsrover.Direction.SOUTH

class ExecuteMissionTest {

    private val executeMission = ExecuteMission()

    @Test
    fun `test actions`() {
        executeMission(
            rover = Rover(x = 2, limit = 3),
            actions = listOf(MOVE, RIGHT, LEFT, RIGHT)
        ).apply {
            x shouldBe 3
            direction shouldBe SOUTH
        }
    }
}
