package ru.pavlentygood.marsrover.console

import ru.pavlentygood.marsrover.domain.Action.MOVE
import ru.pavlentygood.marsrover.domain.Coordinate
import ru.pavlentygood.marsrover.domain.Rover
import ru.pavlentygood.marsrover.domain.Side
import ru.pavlentygood.marsrover.domain.Side.EAST
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

fun String.toSide() = EAST

fun String.toActions() = listOf(MOVE)

fun Rover.toResponse() = "${x.value} ${y.value} ${side.toResponse()}"

fun Side.toResponse() = "W"
