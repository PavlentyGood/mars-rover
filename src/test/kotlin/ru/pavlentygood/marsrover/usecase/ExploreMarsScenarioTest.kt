package ru.pavlentygood.marsrover.usecase

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.domain.Rover
import ru.pavlentygood.marsrover.domain.Side
import ru.pavlentygood.marsrover.domain.rover

class ExploreMarsScenarioTest {

    private val exploreMars = ExploreMarsScenario()

    @Test
    fun `explore mars`() {
        exploreMars(
            rover = rover(),
            actions = listOf(Rover::step, Rover::right, Rover::step, Rover::left, Rover::left)
        ) shouldBe rover(x = 3, y = 4, side = Side.NORTH)
    }
}
