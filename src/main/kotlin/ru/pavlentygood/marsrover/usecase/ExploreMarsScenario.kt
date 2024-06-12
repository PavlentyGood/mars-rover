package ru.pavlentygood.marsrover.usecase

import ru.pavlentygood.marsrover.domain.Action
import ru.pavlentygood.marsrover.domain.Rover

class ExploreMarsScenario : ExploreMars {
    override operator fun invoke(rover: Rover, actions: List<Action>): Rover =
        actions.firstOrNull()
            ?.let {
                this(
                    rover = it.execute(rover),
                    actions = actions.drop(1)
                )
            } ?: rover
}
