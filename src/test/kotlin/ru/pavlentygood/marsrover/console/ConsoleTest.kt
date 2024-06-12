package ru.pavlentygood.marsrover.console

import io.kotest.assertions.throwables.shouldThrowMessage
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.domain.Action
import ru.pavlentygood.marsrover.domain.Action.*
import ru.pavlentygood.marsrover.domain.Rover
import ru.pavlentygood.marsrover.domain.Side.*
import ru.pavlentygood.marsrover.domain.rover
import java.io.ByteArrayOutputStream

class ConsoleTest {

    @Test
    fun `process console`() {
        val input = "8 9\n5 7 E\nM\n".byteInputStream()
        val output = ByteArrayOutputStream()

        val exploreMars = { rover: Rover, actions: List<Action> ->
            rover shouldBe rover(x = 5, y = 7, side = EAST)
            actions shouldBe listOf(MOVE)
            rover(x = 2, y = 1, side = WEST)
        }

        Console(input, output, exploreMars).process()

        output.toString(Charsets.UTF_8) shouldBe """
            Enter field size:
            Enter rover position:
            Enter actions:
            Result rover position: 2 1 W
            """.trimIndent()
    }

    @Test
    fun `string to side`() {
        "N".toSide() shouldBe NORTH
        "E".toSide() shouldBe EAST
        "S".toSide() shouldBe SOUTH
        "W".toSide() shouldBe WEST
        shouldThrowMessage("Incorrect side: B") { "B".toSide() }
    }

    @Test
    fun `side to response`() {
        NORTH.toResponse() shouldBe "N"
        EAST.toResponse() shouldBe "E"
        SOUTH.toResponse() shouldBe "S"
        WEST.toResponse() shouldBe "W"
    }

    @Test
    fun `string to actions`() {
        "".toActions() shouldBe listOf()
        "M".toActions() shouldBe listOf(MOVE)
        "R".toActions() shouldBe listOf(RIGHT)
        "L".toActions() shouldBe listOf(LEFT)
        "LRMR".toActions() shouldBe listOf(LEFT, RIGHT, MOVE, RIGHT)
        shouldThrowMessage("Incorrect action: B") { "B".toActions() }
    }
}
