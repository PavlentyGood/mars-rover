package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.console.Console
import ru.pavlentygood.marsrover.usecase.ExploreMarsScenario
import java.io.ByteArrayOutputStream

class MarsRoverIT {

    @Test
    fun `examples from task`() {
        val exampleCount = 2
        val firstExample = "5 5\n1 2 N\nLMLMLMLMM\n"
        val secondExample = "5 5\n3 3 E\nMMRMMRMRRM\n"

        val input = "$firstExample$secondExample".byteInputStream()
        val output = ByteArrayOutputStream()
        val exploreMars = ExploreMarsScenario()
        val console = Console(input, output, exploreMars)

        repeat(exampleCount) {
            console.process()
        }

        output.toString(Charsets.UTF_8) shouldBe """
            Enter field size:
            Enter rover position:
            Enter actions:
            Result rover position: 1 3 N
            
            Enter field size:
            Enter rover position:
            Enter actions:
            Result rover position: 5 1 E
            
            
        """.trimIndent()
    }
}
