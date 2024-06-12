package ru.pavlentygood.marsrover.console

import ru.pavlentygood.marsrover.domain.Rover
import ru.pavlentygood.marsrover.domain.Side
import ru.pavlentygood.marsrover.domain.Side.*
import ru.pavlentygood.marsrover.usecase.ExploreMars
import java.io.InputStream
import java.io.OutputStream
import java.util.*

class Console(
    input: InputStream,
    private val output: OutputStream,
    private val exploreMars: ExploreMars
) {
    private val scanner = Scanner(input)

    fun process() {
        println("Enter field size:")
        val width = scanner.next().toInt()
        val height = scanner.next().toInt()

        println("Enter rover position:")
        val x = scanner.next().toInt()
        val y = scanner.next().toInt()
        val side = scanner.next().toSide()

        println("Enter actions:")
        val actions = scanner.next().toActions()

        val rover = Rover.create(width, height, x, y, side)

        val resultRover = exploreMars(rover = rover, actions = actions)

        println(resultRover.toResponse())
    }

    private fun println(text: String) =
        output.write("$text\n".toByteArray())

    private fun Rover.toResponse() =
        "Result rover position: ${x.value} ${y.value} ${side.toResponse()}\n"
}

private val sides = listOf(
    Pair("N", NORTH),
    Pair("E", EAST),
    Pair("S", SOUTH),
    Pair("W", WEST)
)

fun String.toSide() =
    sides.find { it.first == this }
        ?.second
        ?: throw Exception("Incorrect side: $this")

fun Side.toResponse() =
    sides.first { it.second == this }.first

fun String.toActions() =
    this.toCharArray().map {
        when (it) {
            'M' -> Rover::step
            'R' -> Rover::right
            'L' -> Rover::left
            else -> throw Exception("Incorrect action: $it")
        }
    }
