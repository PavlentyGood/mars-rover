package ru.pavlentygood.marsrover

import ru.pavlentygood.marsrover.Action.MOVE
import ru.pavlentygood.marsrover.Action.RIGHT

class ExecuteMission {
    operator fun invoke(rover: Rover, actions: List<Action>): Rover =
        if (actions.isEmpty()) rover
        else this(
            rover = when (actions.first()) {
                MOVE -> rover.step()
                RIGHT -> rover.right()
            },
            actions = actions.drop(1)
        )
}
