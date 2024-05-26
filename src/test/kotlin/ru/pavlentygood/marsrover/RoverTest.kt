package ru.pavlentygood.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RoverTest {

    @Test
    fun `no actions`() {
        val start = Position(x = 0, y = 0, direction = Direction.NORTH)
        val actions = emptyArray<Action>()
        val position = Rover().move(start, actions)
        position shouldBe start
    }

    @Test
    fun `move one time`() {
        val start = Position(x = 0, y = 0, direction = Direction.NORTH)
        val actions = arrayOf(Action.MOVE)
        val position = Rover().move(start, actions)
        position shouldBe Position(x = 0, y = 1, direction = Direction.NORTH)
    }

    @Test
    fun `move two times`() {
        val start = Position(x = 0, y = 0, direction = Direction.NORTH)
        val actions = arrayOf(Action.MOVE, Action.MOVE)
        val position = Rover().move(start, actions)
        position shouldBe Position(x = 0, y = 2, direction = Direction.NORTH)
    }

    @Test
    fun `to right`() {
        val start = Position(x = 0, y = 0, direction = Direction.NORTH)
        val actions = arrayOf(Action.RIGHT)
        val position = Rover().move(start, actions)
        position shouldBe Position(x = 0, y = 0, direction = Direction.EAST)
    }

    @Test
    fun `four times to right`() {
        val start = Position(x = 0, y = 0, direction = Direction.NORTH)
        val actions = arrayOf(Action.RIGHT, Action.RIGHT, Action.RIGHT, Action.RIGHT)
        val position = Rover().move(start, actions)
        position shouldBe Position(x = 0, y = 0, direction = Direction.NORTH)
    }

    @Test
    fun `to left`() {
        val start = Position(x = 0, y = 0, direction = Direction.NORTH)
        val actions = arrayOf(Action.LEFT)
        val position = Rover().move(start, actions)
        position shouldBe Position(x = 0, y = 0, direction = Direction.WEST)
    }

    @Test
    fun `four times to left`() {
        val start = Position(x = 0, y = 0, direction = Direction.NORTH)
        val actions = arrayOf(Action.LEFT, Action.LEFT, Action.LEFT, Action.LEFT)
        val position = Rover().move(start, actions)
        position shouldBe Position(x = 0, y = 0, direction = Direction.NORTH)
    }

    @Test
    fun `to right and move`() {
        val start = Position(x = 0, y = 0, direction = Direction.NORTH)
        val actions = arrayOf(Action.RIGHT, Action.MOVE)
        val position = Rover().move(start, actions)
        position shouldBe Position(x = 1, y = 0, direction = Direction.EAST)
    }

    @Test
    fun `to left and move`() {
        val start = Position(x = 0, y = 0, direction = Direction.NORTH)
        val actions = arrayOf(Action.LEFT, Action.MOVE)
        val position = Rover().move(start, actions)
        position shouldBe Position(x = -1, y = 0, direction = Direction.WEST)
    }

    @Test
    fun `two times to right and move`() {
        val start = Position(x = 0, y = 0, direction = Direction.NORTH)
        val actions = arrayOf(Action.RIGHT, Action.RIGHT, Action.MOVE)
        val position = Rover().move(start, actions)
        position shouldBe Position(x = 0, y = -1, direction = Direction.SOUTH)
    }
}
