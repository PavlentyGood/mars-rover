package ru.pavlentygood.marsrover.console

import ru.pavlentygood.marsrover.domain.Action.*
import ru.pavlentygood.marsrover.domain.Coordinate
import ru.pavlentygood.marsrover.domain.Rover
import ru.pavlentygood.marsrover.domain.Side
import ru.pavlentygood.marsrover.domain.Side.*
import ru.pavlentygood.marsrover.usecase.ExploreMars
import java.io.InputStream
import java.io.OutputStream
import java.io.PrintStream
import java.util.*

class Console(
    private val input: InputStream,
    private val output: OutputStream,
    private val exploreMars: ExploreMars
) {
    fun process() {
        val scanner = Scanner(input)
        val width = scanner.next().toInt()
        val height = scanner.next().toInt()
        val x = scanner.next().toInt()
        val y = scanner.next().toInt()
        val side = scanner.next().toSide()
        val actions = scanner.next().toActions()

        val rover = Rover(
            x = Coordinate(value = x, limit = width),
            y = Coordinate(value = y, limit = height),
            side = side
        )

        val resultRover = exploreMars(rover = rover, actions = actions)

        PrintStream(output).print(resultRover.toResponse())
    }
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
            'M' -> MOVE
            'R' -> RIGHT
            'L' -> LEFT
            else -> throw Exception("Incorrect action: $it")
        }
    }

fun Rover.toResponse() = "${x.value} ${y.value} ${side.toResponse()}"
