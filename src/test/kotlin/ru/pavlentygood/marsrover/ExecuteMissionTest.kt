package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.Action.MOVE
import ru.pavlentygood.marsrover.Action.RIGHT

class ExecuteMissionTest {

    private val executeMission = ExecuteMission()

    @Test
    fun `execute actions`() {
        executeMission(
            rover = rover(),
            actions = listOf(MOVE, RIGHT)
        ) shouldBe RIGHT.execute(MOVE.execute(rover()))
    }
}
