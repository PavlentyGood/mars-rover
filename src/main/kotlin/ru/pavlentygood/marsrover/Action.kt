package ru.pavlentygood.marsrover

enum class Action(
    val execute: (Rover) -> Rover
) {
    MOVE(Rover::step),
    RIGHT(Rover::turn)
}
