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
            actions = listOf(MOVE, RIGHT, MOVE, LEFT, LEFT)
        ) shouldBe rover(x = 3, y = 4, side = Side.NORTH)
    }
}
