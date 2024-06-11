package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.Action.*

class ExploreMarsTest {

    private val exploreMars = ExploreMars()

    @Test
    fun `explore mars`() {
        exploreMars(
            rover = rover(),
            actions = listOf(MOVE, RIGHT, LEFT)
        ) shouldBe LEFT.execute(RIGHT.execute(MOVE.execute(rover())))
    }
}
