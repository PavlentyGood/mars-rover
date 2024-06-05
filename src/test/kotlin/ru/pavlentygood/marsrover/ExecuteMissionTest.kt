package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.Action.MOVE
import ru.pavlentygood.marsrover.Action.RIGHT

class ExecuteMissionTest {

    private val executeMission = ExecuteMission()

    @Test
    fun `move and right`() {
        executeMission(
            rover = Rover(x = 2, limit = 3),
            actions = listOf(MOVE, RIGHT)
        ).apply {
            x shouldBe 3
            offsetIndex shouldBe 1
        }
    }
}
