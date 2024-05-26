package ru.pavlentygood.marsrover

class Rover {
    fun move(startPosition: Position, actions: Array<Action>): Position {
        var x = startPosition.x
        var y = startPosition.y
        var direction = startPosition.direction

        for (action in actions) {
            if (action == Action.MOVE) {
                x += direction.xOffset
                y += direction.yOffset
            } else {
                val directionsCount = Direction.values().size
                val k = if (action == Action.RIGHT) 1 else directionsCount - 1
                val nextDirectionIndex = (direction.ordinal + k) % directionsCount
                direction = Direction.values()[nextDirectionIndex]
            }
        }

        return Position(x, y, direction)
    }
}
