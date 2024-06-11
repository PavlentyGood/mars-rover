package ru.pavlentygood.marsrover.domain

enum class Action(
    val execute: (Rover) -> Rover
) {
    MOVE(Rover::step),
    RIGHT(Rover::right),
    LEFT(Rover::left)
}
