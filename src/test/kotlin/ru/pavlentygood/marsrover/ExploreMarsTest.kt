package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.Action.MOVE
import ru.pavlentygood.marsrover.Action.RIGHT

class ExploreMarsTest {

    private val exploreMars = ExploreMars()

    @Test
    fun `explore mars`() {
        exploreMars(
            rover = rover,
            actions = listOf(MOVE, RIGHT)
        ) shouldBe RIGHT.execute(MOVE.execute(rover))
    }
}
