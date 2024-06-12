package ru.pavlentygood.marsrover.console

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.domain.Action
import ru.pavlentygood.marsrover.domain.Rover
import ru.pavlentygood.marsrover.domain.Side.EAST
import ru.pavlentygood.marsrover.domain.Side.WEST
import ru.pavlentygood.marsrover.domain.rover
import java.io.ByteArrayOutputStream

class ConsoleTest {

    @Test
    fun `process console`() {
        val input = "8 9\n5 7 E\nM\n".byteInputStream()
        val output = ByteArrayOutputStream()

        val exploreMars = { rover: Rover, actions: List<Action> ->
            rover shouldBe rover(x = 5, y = 7, side = EAST)
            actions shouldBe listOf(Action.MOVE)
            rover(x = 2, y = 1, side = WEST)
        }

        Console(input, output, exploreMars).process()

        output.toString(Charsets.UTF_8) shouldBe "2 1 W"
    }
}
