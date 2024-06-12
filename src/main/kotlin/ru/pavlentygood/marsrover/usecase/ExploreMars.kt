package ru.pavlentygood.marsrover.usecase

import ru.pavlentygood.marsrover.domain.Action
import ru.pavlentygood.marsrover.domain.Rover

fun interface ExploreMars {
    operator fun invoke(rover: Rover, actions: List<Action>): Rover
}
