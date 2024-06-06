package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.Action.*

class ExecuteMissionTest {

    private val executeMission = ExecuteMission()

    @Test
    fun `test actions`() {
        executeMission(
            rover = rover(x = 2),
            actions = listOf(MOVE, RIGHT, LEFT, RIGHT)
        ).x shouldBe 3
    }
}
