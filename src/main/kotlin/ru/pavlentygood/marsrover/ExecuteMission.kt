package ru.pavlentygood.marsrover

class ExecuteMission {
    operator fun invoke(rover: Rover, actions: List<Action>): Rover =
        if (actions.isEmpty()) rover
        else this(
            rover = actions.first().execute(rover),
            actions = actions.drop(1)
        )
}
