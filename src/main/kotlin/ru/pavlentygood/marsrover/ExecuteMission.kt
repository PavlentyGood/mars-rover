package ru.pavlentygood.marsrover

class ExecuteMission {
    operator fun invoke(rover: Rover, actions: List<Action>): Rover =
        actions.firstOrNull()
            ?.let {
                this(
                    rover = it.execute(rover),
                    actions = actions.drop(1)
                )
            } ?: rover
}
